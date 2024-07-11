package entity;

public class ReturnEn implements SuperEntity {
    private int id;
    private int member_id;
    private int book_id;
    private String issue_date;
    private String due_date;
    private String return_date;
    public ReturnEn(int id, int member_id, int book_id, String issue_date, String due_date, String return_date) {
        this.id = id;
        this.member_id = member_id;
        this.book_id = book_id;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.return_date = return_date;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMember_id() {
        return member_id;
    }
    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public String getIssue_date() {
        return issue_date;
    }
    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }
    public String getDue_date() {
        return due_date;
    }
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
    public String getReturn_date() {
        return return_date;
    }
    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    
}
