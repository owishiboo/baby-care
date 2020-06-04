package thebabycareproject;
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
        gl.loadUI("vaccineReminder", borderpane);
    }
        
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void pop_ups(ActionEvent event){
        gl.loadUI("pop_ups", borderpane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gl.loadUI("vaccineReminder", borderpane);
    }    
    
}
