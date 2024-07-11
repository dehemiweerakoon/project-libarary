package bo;

import bo.custom.customImpl.BookBoImpl;
import bo.custom.customImpl.BorrowBoImpl;
import bo.custom.customImpl.CategoryBoImpl;
import bo.custom.customImpl.MemberBoImpl;
import bo.custom.customImpl.ReturnBoImpl;
import bo.custom.customImpl.UserBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){

    }
    public static BoFactory getInstant(){
         if(boFactory == null){
            boFactory = new BoFactory();
            return boFactory;
         }else{
            return boFactory;
         }
    }
    public enum botype{
        USER, CATEGORY,BOOK,MEMBER,BORROW,RETURN;
    }
    @SuppressWarnings("unchecked")
    public <T>T getBo(botype botype){
        switch (botype) {
            case USER:
                return (T) new UserBoImpl();
            case CATEGORY:
                return (T) new CategoryBoImpl();
            case BOOK:
                return (T) new BookBoImpl();
            case MEMBER:
                return (T) new MemberBoImpl();
            case BORROW:
                return (T) new BorrowBoImpl();
            case RETURN:
                return (T) new ReturnBoImpl();
            default:
                return null;
        }
    }
}
