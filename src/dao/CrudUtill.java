package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DbConnection;

@SuppressWarnings("unchecked")
public class CrudUtill {
    public static <T>T execute(String sql,Object... args) throws ClassNotFoundException,SQLException{
        PreparedStatement preparedStatement = DbConnection.getDbConnection().getConnection().prepareStatement(sql);
        for(int i=0 ;i<args.length;i++){
            preparedStatement.setObject(i+1, args[i]);
        }
        if(sql.startsWith("SELECT")){
            return (T) preparedStatement.executeQuery();
        }
        return (T) (Boolean)(preparedStatement.executeUpdate()>0);
    }
}
