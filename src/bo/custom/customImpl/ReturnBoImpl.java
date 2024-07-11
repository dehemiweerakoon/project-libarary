package bo.custom.customImpl;

import bo.BoFactory;
import bo.BoFactory.botype;
import bo.custom.BookBo;
import bo.custom.MemberBo;
import bo.custom.ReturnBo;
import dao.DaoFactory;
import dao.DaoFactory.DaoType;
import dao.custom.Returndao;
import db.DbConnection;
import dto.BookDto;
import dto.MemberDto;
import dto.ReturnDto;
import entity.ReturnEn;

public class ReturnBoImpl implements ReturnBo{


    Returndao returndao = DaoFactory.getDaoFactory().getDao(DaoType.RETURN);
    BookBo bookBo = BoFactory.getInstant().getBo(botype.BOOK);
    MemberBo memberBo = BoFactory.getInstant().getBo(BoFactory.botype.MEMBER);

    @Override
    public Boolean saveReturn(ReturnDto returnDto, BookDto bookDto, MemberDto memberDto) throws Exception {
       try {
         DbConnection.getDbConnection().getConnection().setAutoCommit(false);
         boolean isSaved = returndao.save(new ReturnEn(returnDto.getId(), returnDto.getMember_id(), returnDto.getBook_id(), returnDto.getIssue_date(), returnDto.getIssue_date(), returnDto.getReturn_date()));
         Boolean isbookUpdated = bookBo.updateBook(bookDto);
         Boolean isMmeberUpdated = memberBo.updateMember(memberDto);
         //System.out.println(isSaved+""+isMmeberUpdated+""+isMmeberUpdated);
         if(isSaved && isbookUpdated && isMmeberUpdated){
            DbConnection.getDbConnection().getConnection().commit();
            return true;
         }else{
            DbConnection.getDbConnection().getConnection().rollback();
            return false;
         }
       } catch (Exception e) {
        DbConnection.getDbConnection().getConnection().rollback();
        System.out.println(e);
        return false;
       }finally{
        DbConnection.getDbConnection().getConnection().setAutoCommit(true);
       }
    }
    
}
