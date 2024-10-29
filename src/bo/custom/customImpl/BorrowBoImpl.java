package bo.custom.customImpl;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import bo.BoFactory;
import bo.custom.BookBo;
import bo.custom.BorrowBo;
import dao.DaoFactory;
import dao.DaoFactory.DaoType;
import dao.custom.Borrowdao;
import db.DbConnection;
import dto.BookDto;
import dto.BorrowDto;
import entity.Borrow;

public class BorrowBoImpl implements BorrowBo {

    Borrowdao borrowdao = DaoFactory.getDaoFactory().getDao(DaoType.BORROW);
    BookBo bookBo = BoFactory.getInstant().getBo(BoFactory.botype.BOOK);


    @Override
    public boolean saveBorrow(BorrowDto BorrowDTO,BookDto bookDto) throws Exception {
       try{
          DbConnection.getDbConnection().getConnection().setAutoCommit(false);
          Boolean isbookModify = bookBo.updateBook(bookDto);
          Boolean isSaved = borrowdao.save(new Borrow(BorrowDTO.getId(), BorrowDTO.getMember_id(), BorrowDTO.getBook_id(), BorrowDTO.getIssue_date(), BorrowDTO.getDue_date()));
          if(isSaved && isbookModify){
            DbConnection.getDbConnection().getConnection().commit();
            return true;
          }else{
            DbConnection.getDbConnection().getConnection().rollback();
            return false;
          }
       }catch(Exception e){
           DbConnection.getDbConnection().getConnection().rollback();
           System.out.println(e);
           return false;
       }finally{
           DbConnection.getDbConnection().getConnection().setAutoCommit(true);
       }
    }

    @Override
    public boolean updateBorrow(BorrowDto BorrowDTO) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateBorrow'");
    }

    @Override
    public boolean deleteBorrow(Integer id) throws Exception {
        return borrowdao.delete(id);
    }

    @Override
    public BorrowDto getBorrow(Integer id) throws Exception {
      Borrow borrow = borrowdao.get(id);
      if(borrow != null){
        return new BorrowDto(borrow.getId(), borrow.getMember_id(), borrow.getBook_id(), borrow.getIssue_date(), borrow.getDue_date());
      }
      return null;
    }

    @Override
    public ArrayList<BorrowDto> getAllBorrow() throws Exception {
       ArrayList<Borrow> borrows = borrowdao.getAll();
       ArrayList<BorrowDto> borrowDtos = new ArrayList<>();
       for(Borrow bo: borrows){
        BorrowDto borrow = new BorrowDto(bo.getId(), bo.getMember_id(), bo.getBook_id(), bo.getIssue_date(), bo.getIssue_date());
        borrowDtos.add(borrow);
       }
       return borrowDtos;
    }

    @Override
    public ArrayList<BorrowDto> getMemberBorrowList(Integer id) throws Exception {
      ArrayList<Borrow> borrows = borrowdao.getMemberBorrowList(id);
       ArrayList<BorrowDto> borrowDtos = new ArrayList<>();
       for(Borrow bo: borrows){
        BorrowDto borrow = new BorrowDto(bo.getId(), bo.getMember_id(), bo.getBook_id(), bo.getIssue_date(), bo.getIssue_date());
        borrowDtos.add(borrow);
       }
       return borrowDtos;
    }

    @Override
    public ArrayList<Integer> getAllBorrowId(Integer user_id, Integer book_id) throws Exception {
      ArrayList<Integer> borrowList = borrowdao.getBookByUserAndName(user_id, book_id);
      return borrowList;
    }
    
}
