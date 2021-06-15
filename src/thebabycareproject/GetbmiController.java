package thebabycareproject;
import com.jfoenix.controls.JFXButton;
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
    static String centerOfFoodAndNutrition = "nutritionalStatus";
    @FXML BorderPane borderpane;
    @FXML JFXButton button1,button2,button3;
    /**
     * Loads ' Home Page '
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void goBack(ActionEvent event) throws IOException{
        NutrimentController.shift = false;
        gl.loadUI(event, "homePage");         
    }
    
    /**
     * Loads fxml in the centerOfFoodAndNutrition of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void nutritionalStatus(ActionEvent event) {
        NutrimentController.shift = false;
        gl.change(gl.ap);
        gl.loadUI("nutritionalStatus",borderpane);
    }
    
    /**
     * Loads fxml in the centerOfFoodAndNutrition of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void nutriment(ActionEvent event) {
        gl.change(gl.ap);
        gl.loadUI("nutriment",borderpane);
    }
    
    /**
     * Loads fxml in the centerOfFoodAndNutrition of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void recipes(ActionEvent event) {
        NutrimentController.shift = false;
        gl.change(gl.ap);
        gl.loadUI("recipes",borderpane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(NutrimentController.shift)button2.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        else button1.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        gl.ap = new JFXButton[]{button1,button2,button3};
        gl.loadUI(centerOfFoodAndNutrition,borderpane);
        centerOfFoodAndNutrition = "nutritionalStatus";
    } 
}