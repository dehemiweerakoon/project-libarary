package dao.custom.customImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtill;
import dao.custom.Bookdao;
import entity.Book;

public class BookDaoImpl implements Bookdao{

    @Override
    public boolean save(Book t) throws Exception {
       return CrudUtill.execute("INSERT INTO books(Title,Author,Category,Year,Publisher,Qty) VALUES(?,?,?,?,?,?)",t.getTitle(),t.getAuthor(),t.getCategory(),t.getYear(),t.getPublisher(),t.getQty());
    }

    @Override
    public boolean delete(Integer id) throws Exception {

       return CrudUtill.execute("DELETE FROM `books` WHERE BookID=?", id) ;
    }

    @Override
    public boolean update(Book t) throws Exception {
       return CrudUtill.execute("UPDATE `books` SET Title=?,Author=? ,Category=? ,Year=?,Publisher=?, Qty=? WHERE BookID=?", t.getTitle(),t.getAuthor(),t.getCategory(),t.getYear(),t.getPublisher(),t.getQty(),t.getBookID());
    }

    @Override
    public Book get(Integer id) throws Exception {
       ResultSet resultSet = CrudUtill.execute("SELECT * FROM `books` WHERE BookID=?",id);
       while (resultSet.next()) {
          return new Book(resultSet.getInt(1), 
          resultSet.getString(2), 
          resultSet.getString(3), 
          resultSet.getString(4), 
          resultSet.getInt(5), 
          resultSet.getString(6),
          resultSet.getInt(7));
       }
       return null;
    }

    @Override
    public ArrayList<Book> getAll() throws Exception {
        ResultSet resultSet = CrudUtill.execute("SELECT*FROM `Books`");
        ArrayList<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book(resultSet.getInt(1),
            resultSet.getString(2), 
             resultSet.getString(3), 
            resultSet.getString(4), 
            resultSet.getInt(5), 
            resultSet.getString(6),
            resultSet.getInt(7));
            books.add(book);
        }
        return books;
    }

    @Override
    public ArrayList<Book> getBookByCategory(String Category) throws Exception{
        ResultSet resultSet = CrudUtill.execute("SELECT*FROM `Books` where category=?",Category);
        ArrayList<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book(resultSet.getInt(1),
            resultSet.getString(2), 
             resultSet.getString(3), 
            resultSet.getString(4), 
            resultSet.getInt(5), 
            resultSet.getString(6),
            resultSet.getInt(7));
            books.add(book);
        }
        return books;
    }
    
}
