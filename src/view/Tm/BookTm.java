package view.Tm;

import javafx.scene.control.Button;

public class BookTm {
    private int BookID;
    private String Title;
    private String Author;
    private String Category;
    private int Year;
    private String Publisher;
    private Button btnDelete;
    private int qty;
    

    

    public BookTm(int bookID, String title, String author, String category, int year, String publisher,int qty,
            Button btnDelete) {
        BookID = bookID;
        Title = title;
        Author = author;
        Category = category;
        Year = year;
        Publisher = publisher;
        this.btnDelete = btnDelete;
        this.qty = qty;
    }
    public BookTm(int bookID, String title, String author, String category, int year, String publisher,
            Button btnDelete) {
        BookID = bookID;
        Title = title;
        Author = author;
        Category = category;
        Year = year;
        Publisher = publisher;
        this.btnDelete = btnDelete;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getBookID() {
        return BookID;
    }
    public void setBookID(int bookID) {
        BookID = bookID;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public int getYear() {
        return Year;
    }
    public void setYear(int year) {
        Year = year;
    }
    public String getPublisher() {
        return Publisher;
    }
    public void setPublisher(String publisher) {
        Publisher = publisher;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }



}
