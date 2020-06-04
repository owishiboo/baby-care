package thebabycareproject;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Controller of the subsection ' quizFillInTheBlanks ' of the section ' Quiz ' of the ' Edu-care ' category.
 * Provides three images with three text fields. One have to write answer in these fields according to the questions.
 * @author 2018331022(Owishi)
 */
public class QuizFillInTheBlanksController implements Initializable {
    QuizHandle qz = new QuizHandle(QuizController.type);
    GoAndLoad gl = new GoAndLoad();
    ImageIcon im = new ImageIcon(100.0,100.0,"src/image/");
    Random random = new Random();
    
    ArrayList<ImageView> imageViewList = new ArrayList<>();
    static ArrayList<ArrayList<String> > quesFillInTheBlanks=  new ArrayList< >();
    
    int pos;
    static int count=0;
    @FXML TextField text1,text2,text3;
    @FXML ImageView i1,i2,i3;
    @FXML Label label;
    @FXML JFXButton next;
    @FXML VBox vbox1,vbox;
    @FXML StackPane stackPane;
    
    /**
     * Loads ' Fun and Learn ' in the center of BorderPane
     * @param event MouseEvent on ImageView
     */
    @FXML
    void goBack(MouseEvent event){
       qz.goBackFunctions(stackPane, vbox, event);
    }
    
    /**
     * Changes text color of question and 'next' button
     * @param event MouseEvent on Label
     */
    @FXML
    void changeTextColor(MouseEvent event){
        qz.changeTextColor(label, next);
    }
    
    /**
     * Loads next type of question or ' Quiz Result '
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML 
    void next(ActionEvent event) throws IOException{
        count++;
        if(count==QuizHandle.limit){
            QuizHandle.givenAnswer.add(text1.getText());
            QuizHandle.givenAnswer.add(text2.getText());
            QuizHandle.givenAnswer.add(text3.getText());
            quesFillInTheBlanks.clear();
            gl.loadUI(event, QuizHandle.nextpage);
        }
        else{        
            Color c = qz.generateLightColor();
            String red = c.toString().substring(17, 20);
            String green = c.toString().substring(23, 26);
            String blue = c.toString().substring(29, 32);
            vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
            next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");                
            QuizHandle.givenAnswer.add(text1.getText());
            QuizHandle.givenAnswer.add(text2.getText());
            QuizHandle.givenAnswer.add(text3.getText());
            text1.setText("");text2.setText("");text3.setText("");
            quesFillInTheBlanks.remove(pos);
            pos = random.nextInt(quesFillInTheBlanks.size());
            chooseRandom(pos);
        }
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qz.callFillInTheBlanks();
        qz.loadTextColor(label, next);
        Color c = qz.generateLightColor();
        String red = c.toString().substring(17, 20);
        String green = c.toString().substring(23, 26);
        String blue = c.toString().substring(29, 32);
        vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
        next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
        imageViewList.add(i1);
        imageViewList.add(i2);
        imageViewList.add(i3);
        pos = random.nextInt(quesFillInTheBlanks.size());
        chooseRandom(pos);
    } 
    
    /**
     * Randomly chooses next question from certain questionList
     * @param pos a random number according to the size of the questionList
     */
    void chooseRandom(int pos){
        ArrayList< String > s = new ArrayList<>();
        s.add(quesFillInTheBlanks.get(pos).get(0));
        
        label.setText(quesFillInTheBlanks.get(pos).get(0));
        
        for(int i=0;i<imageViewList.size();i++){
            int k = random.nextInt(quesFillInTheBlanks.get(pos).size());
            if(k==0)k=1;
            s.add(quesFillInTheBlanks.get(pos).get(k).toUpperCase());
            //System.out.println(quesFillInTheBlanks.get(pos).get(k));
            im.setImage(quesFillInTheBlanks.get(pos).get(k), imageViewList.get(i));
            quesFillInTheBlanks.get(pos).remove(k);
        }
        QuizHandle.correctAnswerList.add(s);
    }        
}
