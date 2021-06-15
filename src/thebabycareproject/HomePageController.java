package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;

/**
 * Controller of 'Homepage'(page that loaded instantly after login).
 * Contains the main four categories - Food &amp; Nutrition, Reminder &amp; Notification, Growth &amp; Immunity, 
 * Edu-corner.
 * Contains Profile settings and logout buttons also.
 * @author 2018331022(Owishi)
 */
public class HomePageController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    
    /**
     * Loads new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void foodChart(ActionEvent event) throws IOException{
        gl.loadUI(event,"foodChart");
    }
    
    /**
     * Loads new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void bmi(ActionEvent event) throws IOException{
        gl.loadUI(event,"getbmi");
    }
    
    /**
     * Loads new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
     void vaccineReminder(ActionEvent event) throws IOException{
        gl.loadUI(event,"reminderAndNotifications");
    }
     
    /**
     * Loads new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void funList(ActionEvent event) throws IOException{
        gl.loadUI(event,"funList");
    }
    
    /**
     * Loads new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void logOut(ActionEvent event) throws IOException{
        gl.loadUI(event,"loginPage");
    }
    
    /**
     * Loads new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void profileSettings(ActionEvent event) throws IOException{
        gl.loadUI(event,"profile");
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {   
    } 
}
