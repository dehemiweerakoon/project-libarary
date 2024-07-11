package dao.custom.customImpl;

import java.util.ArrayList;

import dao.CrudUtill;
import dao.custom.Returndao;
import entity.ReturnEn;

public class ReturnDaoImpl implements Returndao{

    @Override
    public boolean save(ReturnEn t) throws Exception {
       return CrudUtill.execute("INSERT INTO `Return`(member_Id,book_id,issue_date,due_date,return_date) VALUES(?,?,?,?,?)",t.getMember_id(),t.getBook_id(),t.getIssue_date(),t.getDue_date(),t.getReturn_date());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean update(ReturnEn t) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ReturnEn get(Integer id) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<ReturnEn> getAll() throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
