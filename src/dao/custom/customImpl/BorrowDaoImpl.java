package dao.custom.customImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtill;
import dao.custom.Borrowdao;
import entity.Borrow;

public class BorrowDaoImpl implements Borrowdao{

    @Override
    public boolean save(Borrow t) throws Exception {
      return CrudUtill.execute("INSERT INTO Borrow(member_id,book_id,issue_date,due_date) VALUES(?,?,?,?)",t.getMember_id(),t.getBook_id(),t.getIssue_date(),t.getDue_date());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
      return CrudUtill.execute("DELETE FROM `Borrow` WHERE id=?",id );
    }

    @Override
    public boolean update(Borrow t) throws Exception {
      
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Borrow get(Integer id) throws Exception {
      ResultSet resultSet = CrudUtill.execute("SELECT * FROM `Borrow` WHERE id=?", id);
      while (resultSet.next()) {
        return new Borrow(
            resultSet.getInt(1),
            resultSet.getInt(2),
            resultSet.getInt(3), 
            resultSet.getString(4),
            resultSet.getString(5));
      }
      return null;
    }

    @Override
    public ArrayList<Borrow> getAll() throws Exception {
      ResultSet resultSet = CrudUtill.execute("SELECT * FROM `Borrow`");
      ArrayList<Borrow> borrows = new ArrayList<>();
      while (resultSet.next()) {
        Borrow borrow = new Borrow(
          resultSet.getInt(1),
            resultSet.getInt(2),
            resultSet.getInt(3), 
            resultSet.getString(4),
            resultSet.getString(5));
       borrows.add(borrow);
      }
      return borrows;
    }

    @Override
    public ArrayList<Borrow> getMemberBorrowList(Integer id) throws Exception {
      ResultSet resultSet = CrudUtill.execute("SELECT * FROM `Borrow` where member_id=?",id);
      ArrayList<Borrow> borrows = new ArrayList<>();
      while (resultSet.next()) {
        Borrow borrow = new Borrow(
          resultSet.getInt(1),
            resultSet.getInt(2),
            resultSet.getInt(3), 
            resultSet.getString(4),
            resultSet.getString(5));
       borrows.add(borrow);
      }
      return borrows;
    }
    
}
