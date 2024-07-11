package entity;

public class Book  implements SuperEntity{
    private int BookID;
    private String Title;
    private String Author;
    private String Category;
    private int Year;
    private String Publisher;
    private int qty;
    
    public Book(int bookID, String title, String author, String category, int year, String publisher,int Qty) {
        BookID = bookID;
        Title = title;
        Author = author;
        Category = category;
        Year = year;
        Publisher = publisher;
        qty = Qty;
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


    public int getQty() {
        return qty;
    }


    public void setQty(int qty) {
        this.qty = qty;
    }

    
}
