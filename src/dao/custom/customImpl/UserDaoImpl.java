package dao.custom.customImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CrudUtill;
import dao.custom.Userdao;
import entity.User;

public class UserDaoImpl implements Userdao{

    @Override
    public boolean save(User t) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean update(User t) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public User get(Integer id) throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<User> getAll() throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public User getCustomerByUserName(String username) throws ClassNotFoundException, SQLException, Exception {
       ResultSet resultSet = CrudUtill.execute("SELECT*FROM `user` WHERE username=?",username);
       while(resultSet.next()){
       return  new User(
        resultSet.getString("username"), 
         resultSet.getString("password"));
       }
       return null;
    }
}
