package bo.custom;

import java.util.ArrayList;

import dto.BookDto;

public interface BookBo {
    public boolean saveBook(BookDto BookDTO) throws Exception;

    public boolean updateBook(BookDto BookDTO) throws Exception;

    public boolean deleteBook(Integer id) throws Exception;

    public BookDto getBook(Integer id) throws Exception;

    public ArrayList<BookDto> getAllBook() throws Exception;

    public ArrayList<BookDto>  getBookByBookname(String Bookname) throws Exception;
}
