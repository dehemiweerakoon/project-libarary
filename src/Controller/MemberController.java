package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import bo.BoFactory;
import bo.custom.MemberBo;
import dto.MemberDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import view.Tm.MemberTm;

public class MemberController {

    @FXML
    private TableColumn<MemberTm, String> colAddress;

    @FXML
    private TableColumn<MemberTm, String> colContactNo;

    @FXML
    private TableColumn<MemberTm, Button> coldelete;

    @FXML
    private TableColumn<MemberTm, String> colfee;

    @FXML
    private TableColumn<MemberTm,Integer> colid;

    @FXML
    private TableColumn<MemberTm, String> colname;

    @FXML
    private RadioButton no;

    @FXML
    private TableView<MemberTm> table;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtName;

    @FXML
    private RadioButton yes;

    @FXML
    private TextField txtfee;


    private int id;
    private MemberBo bo = BoFactory.getInstant().getBo(BoFactory.botype.MEMBER);

    public void initialize() throws ClassNotFoundException, SQLException {
        getMembers();
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));;
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colfee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        coldelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
    }

    private void getMembers(){
        try {
            ArrayList<MemberDto> memberDtos = bo.getAllMember();
            ObservableList<MemberTm> tmList = FXCollections.observableArrayList();
            for(MemberDto mem: memberDtos){
                 Button btnDelete = new Button("Delete");
                btnDelete.setMaxSize(100, 50);
                btnDelete.setCursor(Cursor.HAND);
                btnDelete.setStyle("-fx-background-color:red; -fx-font-weight:bold");
                btnDelete.setTextFill(Color.web("white"));
                MemberTm memberTm = new MemberTm(mem.getId(), mem.getName(), mem.getContactNo(), mem.getAddress(), mem.getFee(), btnDelete);
                tmList.add(memberTm);
                btnDelete.setOnAction((e) -> {
                     ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
                   ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
                   Optional<ButtonType> result = alert.showAndWait();
                   if(result.orElse(no)==ok){
                    try {
                        if(bo.deleteMember(mem.getId())){
                           new Alert(AlertType.CONFIRMATION, "Member is deleted.!").show();
                           getMembers();
                           return; 
                        }
                    } catch (Exception e1) {
                        new Alert(AlertType.ERROR, "Member is deletion Falied.!").show(); 
                    }
                   }
                });
            }
            table.setItems(tmList);
            table.setRowFactory(tv -> {
                TableRow<MemberTm> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (!row.isEmpty()) {
                        MemberTm rowData = row.getItem();
                        id = rowData.getId();
                         txtName.setText(rowData.getName());
                         txtAddress.setText(rowData.getAddress());
                         txtContactNo.setText(rowData.getContactNo());
                    }
                });
                return row;

            });
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Member is not avaliable .!").show(); 
        }
        
    }

    @FXML
    void OnActionAdd(ActionEvent event) {
      
      try {
      String name = txtName.getText();
      String contactNo = txtContactNo.getText();
      String address = txtAddress.getText();
      txtfee.setText(""+0);
      // In the creation of the member that member dont have any fee it it to zero
      ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
      ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
      Optional<ButtonType> result = alert.showAndWait();
      if(result.orElse(no)==ok){
        if(bo.saveMember(new MemberDto(0, name, contactNo, address,0 ))){
            new Alert(AlertType.INFORMATION, "Member saved   .!").show(); 
            getMembers();
        }
      }


      } catch (Exception e) {
        new Alert(AlertType.ERROR, "Please add the details  .!").show(); 
      }
      txtAddress.setText("");
      txtContactNo.setText("");
      txtName.setText("");
      txtfee.setText("");
    }
    // update an memeber

    @FXML
    void OnActionUpdate(ActionEvent event) {
        try {
            String name = txtName.getText();
            String contactNo = txtContactNo.getText();
            String address = txtAddress.getText();
            int fee = Integer.parseInt(txtfee.getText());
            ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
            ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.orElse(no)==ok){
              if(bo.updateMember(new MemberDto(id, name, contactNo, address,fee ))){
                  new Alert(AlertType.INFORMATION, "Member Updated   .!").show(); 
                  getMembers();
              }
            }
      
      
            } catch (Exception e) {
              new Alert(AlertType.ERROR, "Please add the details  .!").show(); 
            }
            txtAddress.setText("");
            txtContactNo.setText("");
            txtName.setText("");
            txtfee.setText("");
    }

}
