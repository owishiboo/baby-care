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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static thebabycareproject.QuizFillInTheBlanksController.quesFillInTheBlanks;
import static thebabycareproject.QuizHandle.i;

/**
 * FXML Controller class
 *
 * @author 2018331022(owishi)
 */
public class TripFillInTheBlanksController implements Initializable {
    @FXML BorderPane borderpane;
    @FXML JFXRadioButton r1,r2,r3;
    @FXML JFXButton takeTrip,next;
    @FXML VBox vbox1;
    @FXML Label labelQues, l1,l2,l3,warn;
    @FXML ImageView i1,i2,i3;
    @FXML StackPane stackPane;
    QuizHandle qz = new QuizHandle();
    GoAndLoad gl = new GoAndLoad();
    ImageIcon im = new ImageIcon(100.0,100.0,"src/image/");
    public void todo(){
        
            labelQues.setText(Integer.toString(i+1)+".   "+QuizFillInTheBlanksController.quesFillInTheBlanks.get(i).get(0));
            im.setImage(quesFillInTheBlanks.get(i).get(1), i1);
            l1.setText(quesFillInTheBlanks.get(i).get(1).toUpperCase());
            im.setImage(quesFillInTheBlanks.get(i).get(2), i2);
            l2.setText(quesFillInTheBlanks.get(i).get(2).toUpperCase());
            im.setImage(quesFillInTheBlanks.get(i).get(3), i3);
            l3.setText(quesFillInTheBlanks.get(i).get(3).toUpperCase());
    }
    void choose(){
        if(r1.isSelected()) qz.alphaNumFillInTheBlanks();
        else if(r2.isSelected())qz.mathGeoFillInTheBlanks();
        if(r3.isSelected())qz.colorAnimalFillInTheBlanks();
    }
    @FXML void goBack(ActionEvent event) throws IOException{
        qz.clear();
        gl.loadUI(event, "funList");
    }
//    /**
//      * Changes text color of question and 'next' button
//      * @param event MouseEvent on Label
//     */
//    @FXML
//    void changeTextColor(MouseEvent event){
//        qz.changeTextColor(labelQues, next);
//    }
    @FXML void takeTrip(ActionEvent event){
        if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected())warn.setText("Please select one");
        else{
            choose();
            QuizHandle.load = true;
            gl.loadUI("tripBlanks",borderpane);
            //todo();
        }
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
        if(i==quesFillInTheBlanks.size()-1){
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
            if(quesFillInTheBlanks.size()==1){
                qz.clear();
                next.setDisable(true);
            }
        }
    }
        
       
    
}
