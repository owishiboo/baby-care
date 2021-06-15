package thebabycareproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Initial java class
 * @author 2018331022(Owishi)
 * @author 2018331059(Sabiha)
 */
public class TheBabyCareProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxHeight(600);
        stage.setMaxWidth(800);
        Scene scene = new Scene(root);
        stage.setTitle("Baby Care");
        stage.setScene(scene);
        stage.show();
        root.requestFocus();
    }
    @Override
    public void stop(){
        System.out.println("Stage is closing");
        // Save file
    }
    /**
     * @param args - not used
     */
    public static void main(String[] args) {
        System.out.println("java version: "+System.getProperty("java.version"));
        System.out.println("javafx.version: " + System.getProperty("javafx.version"));
        launch(args);
    }
    
}
