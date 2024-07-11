package entity;

public class Member implements SuperEntity {
    private int id;
    private String name;
    private String contactNo;
    private String address;
    private int fee;
    
    public Member(int id, String name, String contactNo, String address, int fee) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }



    

}
