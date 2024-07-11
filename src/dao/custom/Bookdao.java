package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.Book;

public interface Bookdao extends CrudDao<Book,Integer>{
    // custom queries 

    public ArrayList<Book> getBookByCategory(String Category) throws Exception;
}
