package bo.custom;

import java.util.ArrayList;

import dto.BookDto;
import dto.BorrowDto;

public interface BorrowBo {
    public boolean saveBorrow(BorrowDto BorrowDTO,BookDto bookDto) throws Exception;

    public boolean updateBorrow(BorrowDto BorrowDTO) throws Exception;

    public boolean deleteBorrow(Integer id) throws Exception;

    public BorrowDto getBorrow(Integer id) throws Exception;

    public ArrayList<BorrowDto> getAllBorrow() throws Exception;

    public ArrayList<BorrowDto> getMemberBorrowList(Integer id) throws Exception;

    public ArrayList<Integer> getAllBorrowId(Integer user_id,Integer book_id) throws Exception;
}
