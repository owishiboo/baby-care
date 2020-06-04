package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller of the section ' Quiz ' of the ' Edu-care ' category.
 * @author 2018331022(Owishi) (Riddles and random quiz).
 * @author 2018331059(Sabiha) (Except riddles and random quiz).
 */
public class QuizController implements Initializable {
    FunListController fl = new FunListController();
    GoAndLoad gl = new GoAndLoad();
    static String type;
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button1(ActionEvent event) throws IOException{
        QuizController.type = "alphaNum";
        gl.loadUI(event,"quizMultipleChoices");  
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button2(ActionEvent event) throws IOException{
        QuizController.type = "mathGeo";
        gl.loadUI(event,"quizMultipleChoices");  
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button3(ActionEvent event) throws IOException{
        QuizController.type = "science";
        gl.loadUI(event,"quizMultipleChoices");  
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button4(ActionEvent event) throws IOException{
        QuizController.type = "generalKnowledge";
        gl.loadUI(event,"quizMultipleChoices"); 
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
        @FXML
    void button5(ActionEvent event) throws IOException{
        QuizController.type = "colorAnimal";
        gl.loadUI(event,"quizMultipleChoices");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button6(ActionEvent event) throws IOException{
        QuizController.type = "riddles";
        gl.loadUI(event,"quizWriteAnswer"); 
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button7(ActionEvent event) throws IOException{
        QuizController.type = "random";
        gl.loadUI(event,"quizMultipleChoices");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
