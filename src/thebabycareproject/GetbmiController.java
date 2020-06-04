package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.layout.BorderPane;

/**
 * Controller of the ' Food &amp; Nutrition ' category.
 * Has three sections - Nutritional Status, Nutriment, Recipes.
 * Sections are organized in the left and always accessible from each other.
 * Nutritional Status is the default section.
 * Nutriment has one subsection.
 * Here subsection is meant as new fxml.
 * @author 2018331022(Owishi)
 */
public class GetbmiController implements Initializable{
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
    void nutritionalStatus(ActionEvent event) {
        gl.loadUI("nutritionalStatus",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void nutriment(ActionEvent event) {
        gl.loadUI("nutriment",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void recipes(ActionEvent event) {
        gl.loadUI("recipes",borderpane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gl.loadUI("nutritionalStatus",borderpane);
    } 
}