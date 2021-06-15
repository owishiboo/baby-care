/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebabycareproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static thebabycareproject.QuizMultipleChoicesController.quesMultipleChoice;
import static thebabycareproject.QuizHandle.i;
public class TripMultipleChoicesController implements Initializable {

    @FXML BorderPane borderpane;
    @FXML JFXRadioButton r1,r2,r3,r4,r5,r7,r8,r9,r10;
    @FXML JFXButton next;
    @FXML VBox vbox1;
    @FXML Label labelQues,warn;
    @FXML StackPane stackPane;
    QuizHandle qz = new QuizHandle();
    GoAndLoad gl = new GoAndLoad();
    public void todo(){
        
            labelQues.setText(Integer.toString(i+1)+".   "+quesMultipleChoice.get(i).get(0));
            r7.setText(quesMultipleChoice.get(i).get(1));
            r7.setSelected(true);
            r8.setText(quesMultipleChoice.get(i).get(2));
            r9.setText(quesMultipleChoice.get(i).get(3));
            r10.setText(quesMultipleChoice.get(i).get(4));
    }
    void choose(){
        if(r1.isSelected()) qz.alphaNumMultipleChoices();
        else if(r2.isSelected())qz.mathGeoMultipleChoices();
        else if(r3.isSelected())qz.scienceMultipleChoices();
        else if(r4.isSelected())qz.gkMultipleChoices();
        else qz.colorAnimalMultipleChoices();
    }
    @FXML void goBack(ActionEvent event) throws IOException{
        qz.clear();
        gl.loadUI(event, "funList");
    }
    /**
      * Changes text color of question and 'next' button
      * @param event MouseEvent on Label
     */
    @FXML
    void changeTextColor(MouseEvent event){
        qz.changeTextColor(labelQues, next);
    }
    @FXML void takeTrip(ActionEvent event){
        if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected() && !r5.isSelected())warn.setText("Please select one");
        else{
            choose();
            QuizHandle.load = true;
            gl.loadUI("tripMultiple",borderpane);
        }
        System.out.print("HI");
    }
    @FXML void next(ActionEvent event){
        i++; 
        todo();     
//        qz.loadTextColor(labelQues, next);
//        String red = qz.generateLightColor().toString().substring(17, 20);
//        String green = qz.generateLightColor().toString().substring(23, 26);
//        String blue = qz.generateLightColor().toString().substring(29, 32);
//        vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
//        next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")"); 
        if(i==quesMultipleChoice.size()-1){
            next.setDisable(true);
            qz.clear();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FunListController.centerOfEduCorner="quiz";
        if(QuizHandle.load){
            todo();
//            qz.loadTextColor(labelQues, next);
//            String red = qz.generateLightColor().toString().substring(17, 20);
//            String green = qz.generateLightColor().toString().substring(23, 26);
//            String blue = qz.generateLightColor().toString().substring(29, 32);
//            vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
//            next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");  
            if(quesMultipleChoice.size()==1){
                qz.clear();
                next.setDisable(true);
            }
        }
    }    
    
}
