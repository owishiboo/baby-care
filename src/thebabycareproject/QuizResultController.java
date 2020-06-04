package thebabycareproject;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import static thebabycareproject.QuizHandle.correctAnswerList;
import static thebabycareproject.QuizHandle.givenAnswer;

/**
 * Controller of the subsection ' quizResult ' of the section ' Quiz ' of the ' Edu-care ' category.
 * Shows scores, the background color is changed randomly in every 1 second.
 * Total 30 marks Random quiz and 15 marks for others.
 * @author 2018331022(Owishi)
 */
public class QuizResultController implements Initializable {
    QuizHandle qz = new QuizHandle(QuizController.type);
    GoAndLoad gl = new GoAndLoad();
    ImageIcon ic = new ImageIcon(90.0,90.0,"src/image/");
    int correctAnswer=0;
    @FXML VBox vbox;
    @FXML Label score, answer, opinion, label1;
    @FXML ImageView imageView;
    
    /**
     * Loads ' Fun and Learn ' in the center of BorderPane
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void goBack(ActionEvent event) throws IOException{
        gl.loadUI(event, "funList");         
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label1.setText(QuizHandle.outOfScore);
        IntegerProperty ip = new SimpleIntegerProperty(0);
            Timeline timeline = new Timeline(
            new KeyFrame(
                    Duration.seconds(1),
                    event -> {
                        Color c = qz.generateLightColor();
                        String red = c.toString().substring(17, 20);
                        String green = c.toString().substring(23, 26);
                        String blue = c.toString().substring(29, 32);
                        vbox.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
                    } 
            )
        );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
    
        for(int j=0;j<correctAnswerList.size();j++){
           String question = correctAnswerList.get(j).get(0);
           answer.setText(answer.getText()+(j+1)+". "+question+"\n");
           System.out.println(question);
           for(int i=1;i<correctAnswerList.get(j).size();i++){
                answer.setText(answer.getText()+"       ("+i+")");
               if("".equals(givenAnswer.get(0))){
                       answer.setText(answer.getText()+" Skipped.\n");
                       givenAnswer.remove(0);
                   }
               else {
                    answer.setText(answer.getText()+" Your Answer : "+givenAnswer.get(0)+"\n");
                    if(givenAnswer.get(0).toUpperCase().equals(correctAnswerList.get(j).get(i).toUpperCase())){                   
                        correctAnswer++;
                        answer.setText(answer.getText()+"   Correct answer.\n");
                    }
                    else{
                        if("".equals(givenAnswer.get(0))){ }
                        else answer.setText(answer.getText()+"  Wrong. ");
                        answer.setText(answer.getText()+" Correct answer : "+correctAnswerList.get(j).get(i)+"\n");
                    }  
                    givenAnswer.remove(0);
                }
           }
        }  
        qz.clear();
        score.setText(Integer.toString(correctAnswer));
        if(" out of 15".equals(QuizHandle.outOfScore)){
            if(correctAnswer==15){
                opinion.setText("Excellent! Perfect scores!");
                ic.setImage("dog_", imageView);
            }
            else if(correctAnswer>8){
                opinion.setText("Good! Keep it up!");
                ic.setImage("002-cat", imageView);
            }
            else if(correctAnswer<7){
                opinion.setText("Not so good scores! So keep Trying!");
                ic.setImage("001-monkey", imageView);
            }
            else {
                opinion.setText("Average. But you can make it better!");
                ic.setImage("003-happy", imageView);
            }
        }
        else{
            if(correctAnswer==30){
                opinion.setText("Excellent! Perfect scores!");
                ic.setImage("dog_", imageView);
            }
            else if(correctAnswer>20){
                opinion.setText("Good! Keep it up!");
                ic.setImage("002-cat", imageView);
            }
            else if(correctAnswer<15){
                opinion.setText("Not so good scores! So keep Trying!");
                ic.setImage("001-monkey", imageView);
            }
            else {
                opinion.setText("Average. But you can make it better!");
                ic.setImage("003-happy", imageView);
            }
        }        
    }     
}
