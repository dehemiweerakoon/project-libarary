import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/Main.fxml"))));
       primaryStage.setTitle("Main Form");
       primaryStage.show();
    }
}
