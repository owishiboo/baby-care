package thebabycareproject;
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
    void quiz(ActionEvent event){
        gl.loadUI("quiz", borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void fun_learn(ActionEvent event){
        gl.loadUI("funAndLearn",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void create_playlist(ActionEvent event){
        gl.loadUI("createPlaylist",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void book_corner(ActionEvent event){
        gl.loadUI("bookCorner",borderpane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gl.loadUI("funAndLearn",borderpane);
    }    
    
}
