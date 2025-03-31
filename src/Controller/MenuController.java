package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController {
    
    @FXML
    private VBox vbox; 
    @FXML
    void btnBookCategoriesOnAction(ActionEvent event) throws IOException {
    //    Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //    //stage1.close();
    //    Stage stage = new Stage();
    //    stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/BookCategory.fxml"))));
    //    stage.setTitle("Book Category Form");
    //    stage.show();
    Parent newView = FXMLLoader.load(getClass().getResource("../view/BookCategory copy.fxml"));
    vbox.getChildren().setAll(newView); // Replace only the contentVBox
    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        // Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // //stage1.close();
        // Stage stage = new Stage();
        // stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Book copy.fxml"))));
        // stage.setTitle("Book Category Form");
        // stage.show();
         // this.root.getChildren().clear();
         // this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/Book copy.fxml")));
        Parent newView = FXMLLoader.load(getClass().getResource("../view/Book copy.fxml"));
        vbox.getChildren().setAll(newView); // Replace only the contentVBox
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
        // Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // //stage1.close();
        // Stage stage = new Stage();
        // stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Member.fxml"))));
        // stage.setTitle("Book Category Form");
        // stage.show();
        Parent newView = FXMLLoader.load(getClass().getResource("../view/Member copy.fxml"));
        vbox.getChildren().setAll(newView); // Replace only the contentVBox
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
