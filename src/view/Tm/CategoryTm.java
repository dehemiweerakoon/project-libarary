package view.Tm;

import javafx.scene.control.Button;

public class CategoryTm {
    private int CategoryID;
    private String CategoryName;
    private Button btnDelete;

    public CategoryTm(int categoryID, String categoryName, Button btnDelete) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        this.btnDelete = btnDelete;
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

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

}
