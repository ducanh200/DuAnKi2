import controller.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Stage rootStage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        HomeController.rootStage = primaryStage;
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setScene(new Scene(root,1000,700));
        primaryStage.show();
    }
}
