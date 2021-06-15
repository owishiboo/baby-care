package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * Controller of the section 'Recipes ' of the ' Food &amp; Nutrition ' category.
 * A youtube playlist of recipes for child.
 * List can't be changed or deleted.
 * @author 2018331022(Owishi)
 */
public class ReminderAndNotificationsController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML BorderPane borderpane;
    @FXML JFXButton button1,button2;    
    
    /**
     * Loads ' Home Page '
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void goBack(ActionEvent event) throws IOException{
        gl.loadUI(event, "homePage");      
    }
        
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void vaccineReminder(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("vaccineReminder", borderpane);
    }
        
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void pop_ups(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("pop_ups", borderpane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button1.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        gl.ap = new JFXButton[]{button1,button2};
        gl.loadUI("vaccineReminder", borderpane);
    }    
    
}
