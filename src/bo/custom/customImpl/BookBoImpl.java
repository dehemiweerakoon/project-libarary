package bo.custom.customImpl;

import java.util.ArrayList;

import bo.custom.BookBo;
import dao.DaoFactory;
import dao.custom.Bookdao;
import dto.BookDto;
import entity.Book;

public class BookBoImpl implements BookBo{


    Bookdao bookdao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.BOOK);

    @Override
    public boolean saveBook(BookDto BookDTO) throws Exception {
        return bookdao.save(new Book(BookDTO.getBookID(),BookDTO.getTitle(), BookDTO.getAuthor(), BookDTO.getCategory(), BookDTO.getYear(),BookDTO.getPublisher(),BookDTO.getQty()));
    }

    @Override
    public boolean updateBook(BookDto BookDTO) throws Exception {
       return bookdao.update(new Book(BookDTO.getBookID(),BookDTO.getTitle(), BookDTO.getAuthor(), BookDTO.getCategory(), BookDTO.getYear(),BookDTO.getPublisher(),BookDTO.getQty()));
    }

    @Override
    public boolean deleteBook(Integer id) throws Exception {
      return bookdao.delete(id);
    }

    @Override
    public BookDto getBook(Integer id) throws Exception {
       Book book = bookdao.get(id);
       if(book != null){
        return new BookDto(book.getBookID(), book.getTitle(), book.getAuthor(), book.getCategory(),book.getYear(), book.getPublisher(),book.getQty());
       }
       return null;
    }

    @Override
    public ArrayList<BookDto> getAllBook() throws Exception {
       ArrayList<Book> books = bookdao.getAll();
       ArrayList<BookDto> bookDtos = new ArrayList<>();
       for(Book b:books){
        BookDto nBookDto = new BookDto(b.getBookID(), b.getTitle(), b.getAuthor(), b.getCategory(), b.getYear(), b.getPublisher(),b.getQty());
        bookDtos.add(nBookDto);
       }
       return bookDtos;
    }

    @Override
    public ArrayList<BookDto> getBookByBookname(String Bookname) throws Exception {
        ArrayList<Book> books = bookdao.getBookByCategory(Bookname);
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        for(Book b:books){
         BookDto nBookDto = new BookDto(b.getBookID(), b.getTitle(), b.getAuthor(), b.getCategory(), b.getYear(), b.getPublisher(),b.getQty());
         bookDtos.add(nBookDto);
        }
        return bookDtos;
    }
    
}
