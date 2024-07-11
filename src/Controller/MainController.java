package Controller;

import java.sql.SQLException;

import bo.BoFactory;
import bo.custom.UserBo;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private AnchorPane root;

    UserBo userBo = BoFactory.getInstant().getBo(BoFactory.botype.USER);

    @FXML
    void Onsubmit(ActionEvent event) {
        System.out.println("hello");
      String txt_username = username.getText();
      String txt_password = password.getText();
     
      try {
          UserDto userDto = userBo.getUserByUsername(txt_username);
          if(userDto !=null){
               if(txt_password.equals(userDto.getPassword())){
                Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage1.close();
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Menu.fxml"))));
                stage.setTitle("Book Category");
                stage.show();
                

               }else{
                new Alert(AlertType.ERROR, "password is incorrect" ).show();
               }
          }else{
            new Alert(AlertType.ERROR, "user is not Found " ).show();
          }
        } catch (ClassNotFoundException e) {
            new Alert(AlertType.ERROR, "class is not Found " + e).show();
        } catch (SQLException e) {
            new Alert(AlertType.ERROR, "sql error" + e).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
