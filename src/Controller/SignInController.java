package Controller;

import bo.BoFactory;
import bo.custom.UserBo;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private TextField contactNo;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField username;


    UserBo userBo = BoFactory.getInstant().getBo(BoFactory.botype.USER);

    @FXML
    void OnSignInClick(ActionEvent event) {

       String text_contactNo = contactNo.getText();
       String text_username = username.getText();
       String text_password = password.getText();
       String text_name = name.getText();

      try {
        Boolean isSaved = userBo.saveUser(new UserDto(text_username, text_password, text_name, text_contactNo));
        if(isSaved){
             new Alert(AlertType.CONFIRMATION, "User Saved" ).show();
               Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage1.close();
        }else{
            new Alert(AlertType.ERROR, "User saved error" ).show();
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      


    }

    @FXML
    void Onsubmit(ActionEvent event) {

    }

}
