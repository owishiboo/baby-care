package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controller of the section ' Quiz ' of the ' Edu-care ' category.
 * @author 2018331022(Owishi) (Riddles and random quiz).
 * @author 2018331059(Sabiha) (Except riddles and random quiz).
 */
public class QuizController implements Initializable {
    FunListController fl = new FunListController();
    static boolean on=false;
    GoAndLoad gl = new GoAndLoad();
    static String type;
    @FXML StackPane stackPane;
    @FXML VBox vbox;
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button1(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "alphaNum";
        QuizHandle.nextpage="quizMultipleChoices";
        gl.loadUI(event,"quizBegin");
        //gl.loadUI(event,"quizMultipleChoices");  
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button2(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "mathGeo";
        QuizHandle.nextpage="quizMultipleChoices";
        gl.loadUI(event,"quizBegin");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button3(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "science";
        QuizHandle.nextpage="quizMultipleChoices";
        gl.loadUI(event,"quizBegin");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button4(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "generalKnowledge";
        QuizHandle.nextpage="quizMultipleChoices";
        gl.loadUI(event,"quizBegin");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
        @FXML
    void button5(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "colorAnimal";
        QuizHandle.nextpage="quizMultipleChoices";
        gl.loadUI(event,"quizBegin");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button6(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "riddles";
        QuizHandle.nextpage = "quizWriteAnswer";
        gl.loadUI(event,"quizBegin");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button7(ActionEvent event) throws IOException{
        on=true;
        QuizController.type = "random";
        QuizHandle.nextpage="quizMultipleChoices";
        gl.loadUI(event,"quizBegin");
    }
     /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button8(ActionEvent event) throws IOException{
        gl.loadUI(event,"tripMultipleChoices");
    }
     /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button9(ActionEvent event) throws IOException{
        gl.loadUI(event,"tripSelect1");
    }
    
    /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button10(ActionEvent event) throws IOException{
        gl.loadUI(event,"tripFillInTheBlanks");
    }
     /**
     * Load new fxml
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void button11(ActionEvent event) throws IOException{
        gl.loadUI(event,"tripWriteAnswer");
    }
    /**
     * Provides informations about weight status
     * @param event ActionEvent
     */
    @FXML
    void clickHere(ActionEvent event){
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Ok, I got it!");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            
            dialog.close();
        });
        dialogLayout.setBody(new Text("Participate quiz: A test with various types of questions in \n" +
        "various fields. Each question contains 1 point.There are 4\n" +
        "types of questions - Multiple Choices, Multiple Choices with\n" +
        "Images, Write Multiple Answers from Images, Write Answer from\n" +
        "Text or Images All types except 'random' have 15 questions in\n" +
        "total. The random type has 30 questions.\n\n" +
        "Take a trip: You may take-a-trip and get the answers of the \n" +
        "quizzes according to their question's type mentioned earlier."));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        dialogLayout.setActions(ok);
        dialog.show();
        vbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        vbox.setEffect(null);
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FunListController.shift2 = true;
        FunListController.centerOfEduCorner = "quiz";
    }    
    
}
