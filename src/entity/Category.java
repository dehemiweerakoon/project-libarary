package entity;

public class Category implements SuperEntity {
    private int CategoryID;
    private String CategoryName;
    
    public Category(int categoryID, String categoryName) {
        CategoryID = categoryID;
        CategoryName = categoryName;
    }
    public int getCategoryID() {
        return CategoryID;
    }
    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }
    public String getCategoryName() {
        return CategoryName;
    }
    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
    
}
