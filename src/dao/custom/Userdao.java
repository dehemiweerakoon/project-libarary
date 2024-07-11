package dao.custom;

import java.sql.SQLException;

import dao.CrudDao;
import entity.User;


public interface Userdao extends CrudDao<User,Integer>{
    public User getCustomerByUserName(String username) throws ClassNotFoundException, SQLException, Exception;
}
