package entity;

public class User implements SuperEntity{
    private String username;
    private String password;
    private String name;
    private String contactNo;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public User(String username, String password, String name, String contactNo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.contactNo = contactNo;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
