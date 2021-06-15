package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
/**
 * Controller of the subsection ' quizMultipleChoices ' of the section ' Quiz ' of the ' Edu-care ' category.
 * Provides four options. Answer the question by choosing one. 
 * @author 2018331022(Owishi)
 * @author 2018331059(Sabiha)
 */
public class QuizMultipleChoicesController implements Initializable {
    QuizHandle qz = new QuizHandle(QuizController.type);
    //QuizBeginController qb = new QuizBeginController();
    GoAndLoad gl = new GoAndLoad();
    Random random = new Random();
    
    ArrayList<JFXRadioButton> buttonList = new ArrayList<>();
    static ArrayList<ArrayList<String> > quesMultipleChoice=  new ArrayList< >();
        
    int pos;
    static int count=0;
    
    @FXML Label labelQues;
    @FXML JFXRadioButton r1,r2,r3,r4;
    @FXML JFXButton next; 
    @FXML VBox vbox1;

     
    /**
      * Changes text color of question and 'next' button
      * @param event MouseEvent on Label
     */
    @FXML
    void changeTextColor(MouseEvent event){
        qz.changeTextColor(labelQues, next);
    }
    
    /**
     * Loads next type of question or ' Quiz Result '
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void next(ActionEvent event) throws IOException{
        boolean id = false;
        count++;
        if(count==QuizHandle.limit){
            //System.out.println("A");
             for(int i=0;i<buttonList.size();i++){
                if(buttonList.get(i).isSelected()){
                    id = true;
                    QuizHandle.givenAnswer.add(buttonList.get(i).getText());
                }
                buttonList.get(i).setSelected(false);
            }
            if(!id)QuizHandle.givenAnswer.add("");
            quesMultipleChoice.clear();
            //qb.startStop(event);
            gl.loadUI(event,"quizBegin");
        }
        else{
//            Color c = qz.generateLightColor();
//            String red = c.toString().substring(17, 20);
//            String green = c.toString().substring(23, 26);
//            String blue = c.toString().substring(29, 32);
//            vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
//            next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
            
            for(int i=0;i<buttonList.size();i++){
                if(buttonList.get(i).isSelected()){
                    id = true;
                    QuizHandle.givenAnswer.add(buttonList.get(i).getText());
                }
                buttonList.get(i).setSelected(false);
            }
            if(!id)QuizHandle.givenAnswer.add("");
            
            quesMultipleChoice.remove(pos);
            pos = random.nextInt(quesMultipleChoice.size());
            chooseRandom(pos);
        }
    }        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qz.callMultipleChoices();  
        //qz.loadTextColor(labelQues, next);
//        String red = qz.generateLightColor().toString().substring(17, 20);
//        String green = qz.generateLightColor().toString().substring(23, 26);
//        String blue = qz.generateLightColor().toString().substring(29, 32);
//        vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
//        next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");        
        buttonList.add(r1);
        buttonList.add(r2);
        buttonList.add(r3);
        buttonList.add(r4);
        pos = random.nextInt(quesMultipleChoice.size());
        chooseRandom(pos);    
    }
    
    /**
     * Randomly chooses next question and sets options randomly from certain questionList
     * @param pos a random number according to the size of the questionList
     */
    void chooseRandom(int pos){
        ArrayList< String > s = new ArrayList<>();
        s.add(quesMultipleChoice.get(pos).get(0));
        s.add(quesMultipleChoice.get(pos).get(1));
        QuizHandle.correctAnswerList.add(s);
        
        labelQues.setText(quesMultipleChoice.get(pos).get(0));
        for(int i=0;i<buttonList.size();i++){
            int k = random.nextInt(quesMultipleChoice.get(pos).size());
            if(k==0)k=1;
            buttonList.get(i).setText(quesMultipleChoice.get(pos).get(k));
            quesMultipleChoice.get(pos).remove(k);
        }      
    }
}
