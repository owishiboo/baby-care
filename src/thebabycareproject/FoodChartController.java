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
 * Controller of the ' Growth &amp; Immunity ' category.
 * Has five sections - Care Playlist, Care Blogs, Growth-charts, Growth Calculator, Autism.
 * Sections are organized in the left and always accessible from each other.
 * Care Playlist is the default section.
 * @author 2018331022(Owishi)
 */
public class FoodChartController implements Initializable {
    @FXML BorderPane borderpane;
    @FXML JFXButton button1,button2,button3,button4,button5;
    GoAndLoad gl = new GoAndLoad();

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
    void careCorner(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("careCorner",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void careArticle(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("careArticle",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void growthCharts(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("growthCharts",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void autism(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("autism",borderpane);
    }
    
    /**
     * Loads fxml in the center of BorderPane
     * @param event ActionEvent
     */
    @FXML
    void growthCalculator(ActionEvent event){
        gl.change(gl.ap);
        gl.loadUI("growthCalculator",borderpane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button1.setStyle("-fx-text-fill: #42070b;-fx-background-color: #E8727D;");
        gl.ap = new JFXButton[]{button1,button2,button3,button4,button5}; 
        gl.loadUI("careCorner",borderpane);
    }
    
}
