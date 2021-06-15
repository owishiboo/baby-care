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
 * Controller of the subsection ' quizWriteAnswer ' of the section ' Quiz ' of the ' Edu-care ' category.
 * Provides a question with or without images, type the correct answer. 
 * @author 2018331022(Owishi)
 */
public class QuizWriteAnswerController implements Initializable {
    QuizHandle qz = new QuizHandle(QuizController.type);
    GoAndLoad gl = new GoAndLoad();
    
    Random random = new Random();
    
    ArrayList<ImageView> imageViewList = new ArrayList<>();
    static ArrayList<ArrayList<String> > quesWriteAnswer =  new ArrayList< >();
    
    int pos;
    static int count=0;
    @FXML TextField text;
    @FXML ImageView i1,i2,i3,i4,i5,i6,i7,i8;
    @FXML Label labelQues;
    @FXML JFXButton next;
    @FXML VBox vbox1,vbox;
    @FXML StackPane stackPane;

    /**
     * Changes text color of question and 'next' button
     * @param event MouseEvent on labelQues
     */
//    @FXML
//    void changeTextColor(MouseEvent event){
//        qz.changeTextColor(labelQues, next);
//    }
//    
    /**
     * Loads next type of question or ' Quiz Result '
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML 
    void next(ActionEvent event) throws IOException{
        count++;
        if(count==QuizHandle.limit){
            QuizHandle.givenAnswer.add(text.getText());
            quesWriteAnswer.clear();
            gl.loadUI(event,"quizBegin");
        }
        else{                    
//            Color c = qz.generateLightColor();        
//            String red = c.toString().substring(17, 20);        
//            String green = c.toString().substring(23, 26);        
//            String blue = c.toString().substring(29, 32);        
//            vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");        
//            next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");     
            System.out.println(text.getText());
            QuizHandle.givenAnswer.add(text.getText());               
            text.setText("");    
            for(int i=0;i<imageViewList.size();i++){   
                imageViewList.get(i).setImage(null);
            }
            quesWriteAnswer.remove(pos);       
            pos = random.nextInt(quesWriteAnswer.size());       
            chooseRandom(pos);
        }
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //qz.loadTextColor(labelQues, next);
        System.out.println("A");
        qz.callWriteAnswer();
        System.out.println("A");
//        Color c = qz.generateLightColor();
//        String red = c.toString().substring(17, 20);
//        String green = c.toString().substring(23, 26);
//        String blue = c.toString().substring(29, 32);
//        vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
//        next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
        
        imageViewList.add(i1);
        imageViewList.add(i2);
        imageViewList.add(i3);
        imageViewList.add(i4);
        imageViewList.add(i5);
        imageViewList.add(i6);
        imageViewList.add(i7);
        imageViewList.add(i8);
        
        pos = random.nextInt(quesWriteAnswer.size());
        chooseRandom(pos);
    } 
    
    /**
     * Randomly chooses next question randomly from certain questionList
     * @param pos Randomly chooses next question and sets options randomly from certain questionList
     */
    void chooseRandom(int pos){
        ArrayList< String > s = new ArrayList<>();
        s.add(quesWriteAnswer.get(pos).get(0));
        s.add(quesWriteAnswer.get(pos).get(1));
        QuizHandle.correctAnswerList.add(s);
        
        labelQues.setText(quesWriteAnswer.get(pos).get(0));                
        if(quesWriteAnswer.get(pos).size()!=2){
            ImageIcon im = new ImageIcon(70.0,70.0,"src/image/");
            int t = Integer.valueOf(quesWriteAnswer.get(pos).get(1));
            for(int i=0;i<imageViewList.size();i++){   
                if(t==0)break;
                t--;
                im.setImage(quesWriteAnswer.get(pos).get(2), imageViewList.get(i));
            }
        }                
    }
    
}