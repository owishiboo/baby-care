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
 * Controller of the ' Edu-corner ' category.
 * Has five sections - Fun and Learn, Book Corner, Quiz, Create Playlist.
 * Fun and Learn is the default section.
 * Create Playlist has one subsection and Quiz has four subsections( can say four types of quiz).
 * Here subsection is meant as new fxml.
 * @author 2018331022(Owishi)
 */
public class FunListController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    static String centerOfEduCorner="funAndLearn";
    static boolean shift2=false,shift3=false;
    @FXML BorderPane borderpane;
    @FXML JFXButton button1,button2,button3,button4;
    
    /**
     * Loads ' Home Page '
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void goBack(ActionEvent event) throws IOException{
        shift2=shift3=false;
        gl.loadUI(event, "homePage");   
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void quiz(ActionEvent event){
        shift2=shift3=false;
        gl.change(gl.ap);
        gl.loadUI("quiz", borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void fun_learn(ActionEvent event){
        shift2=shift3=false;
        gl.change(gl.ap);
        gl.loadUI("funAndLearn",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void create_playlist(ActionEvent event){
        shift2=shift3=false;
        gl.change(gl.ap);
        gl.loadUI("createPlaylist",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void book_corner(ActionEvent event){
        shift2=shift3=false;
        gl.change(gl.ap);
        gl.loadUI("bookCorner",borderpane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(shift2)button3.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        else if(shift3)button4.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        else button1.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        gl.ap = new JFXButton[]{button1,button2,button3,button4}; 
        gl.loadUI(centerOfEduCorner,borderpane);
        centerOfEduCorner="funAndLearn";
    }    
    
}
