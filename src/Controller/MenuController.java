package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    void btnBookCategoriesOnAction(ActionEvent event) throws IOException {
       Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
       //stage1.close();
       Stage stage = new Stage();
       stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/BookCategory.fxml"))));
       stage.setTitle("Book Category Form");
       stage.show();
    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage1.close();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Book.fxml"))));
        stage.setTitle("Book Category Form");
        stage.show();
    }

    @FXML
    void btnBorrowingOnAction(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage1.close();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Borrow.fxml"))));
        stage.setTitle("Book Category Form");
        stage.show();
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage1.close();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Member.fxml"))));
        stage.setTitle("Book Category Form");
        stage.show();
    }
    @FXML
    void onReturnAction(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage1.close();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Return.fxml"))));
        stage.setTitle("Book Category Form");
        stage.show();
    }
}
