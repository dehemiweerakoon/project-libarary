package dao;

import dao.custom.customImpl.BookDaoImpl;
import dao.custom.customImpl.BorrowDaoImpl;
import dao.custom.customImpl.CategoryDaoImpl;
import dao.custom.customImpl.MemberDaoImpl;
import dao.custom.customImpl.ReturnDaoImpl;
import dao.custom.customImpl.UserDaoImpl;

@SuppressWarnings("unchecked")
public class DaoFactory {
    public static DaoFactory daoFactory;

    private DaoFactory(){

    }
    public static DaoFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory=new DaoFactory();
            return daoFactory;
        }else{
            return daoFactory;
        }
    }
  public enum DaoType{
    USER,CATEGORY,BOOK,MEMBER,BORROW,RETURN;
  } 
  public <T> T getDao(DaoType daoType){
    switch (daoType) {
        case USER:
            return (T) new UserDaoImpl();
        case CATEGORY:
             return (T) new CategoryDaoImpl();
        case BOOK:
             return (T) new BookDaoImpl();
        case MEMBER:
             return (T) new MemberDaoImpl();
        case BORROW:
             return (T) new BorrowDaoImpl();
        case RETURN:
             return (T) new ReturnDaoImpl();
        default:
             return null;
    }
  }
}
