package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.Borrow;

public interface Borrowdao extends CrudDao<Borrow,Integer>{
    public ArrayList<Borrow> getMemberBorrowList(Integer id) throws Exception;
}
