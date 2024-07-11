package dao.custom.customImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtill;
import dao.custom.Categorydao;
import entity.Category;

public class CategoryDaoImpl implements Categorydao {

    @Override
    public boolean save(Category t) throws Exception {
      return  CrudUtill.execute("INSERT INTO Categories(CategoryName) VALUES(?)",t.getCategoryName());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
       return CrudUtill.execute("DELETE FROM `categories` where CategoryID=?", id);
    }

    @Override
    public boolean update(Category t) throws Exception {
       return CrudUtill.execute("UPDATE `Categories` SET CategoryName=? WHERE CategoryID=?", t.getCategoryName(),t.getCategoryID());
    }

    @Override
    public Category get(Integer id) throws Exception {
      ResultSet resultSet = CrudUtill.execute("SELECT * FROM `categories` where CategoryID=?", id);
      while (resultSet.next()) {
        return new Category(
        resultSet.getInt("CategoryID"), 
        resultSet.getString("CategoryName")
        );
      }
      return null;
    }

    @Override
    public ArrayList<Category> getAll() throws Exception {
       ResultSet resultSet = CrudUtill.execute("SELECT*FROM `categories`");
       ArrayList<Category> categories = new ArrayList<>();
       while (resultSet.next()) {
         categories.add(new Category(resultSet.getInt(1), resultSet.getString(2)));
       }
       return categories;
    }
    
}
