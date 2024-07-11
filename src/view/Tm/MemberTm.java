package view.Tm;

import javafx.scene.control.Button;

public class MemberTm {
    private int id;
    private String name;
    private String contactNo;
    private String address;
    private int fee;
    private Button btnDelete;
    public MemberTm(int id, String name, String contactNo, String address, int fee, Button btnDelete) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.fee = fee;
        this.btnDelete = btnDelete;
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
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    
}
