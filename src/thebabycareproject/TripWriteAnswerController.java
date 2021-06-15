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
import java.util.ArrayList;
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
import static thebabycareproject.QuizHandle.i;
import static thebabycareproject.QuizWriteAnswerController.quesWriteAnswer;

/**
 * FXML Controller class
 *
 * @author 2018331022(owishi)
 */
public class TripWriteAnswerController implements Initializable {

    @FXML BorderPane borderpane;
    @FXML ImageView i1,i2,i3,i4,i5,i6,i7,i8;
    @FXML JFXRadioButton r1,r2,r3;
    @FXML JFXButton next;
    @FXML VBox vbox1;
    ImageIcon im = new ImageIcon(70.0,70.0,"src/image/");
    @FXML Label labelQues,warn,answer;
    @FXML StackPane stackPane;
    QuizHandle qz = new QuizHandle();
    GoAndLoad gl = new GoAndLoad();
    static ArrayList<ImageView> imageViewList = new ArrayList<>();
    public void todo(){
           for(int i=0;i<imageViewList.size();i++){   
                imageViewList.get(i).setImage(null);
            }
           labelQues.setText(Integer.toString(i+1)+".   "+quesWriteAnswer.get(i).get(0));
           answer.setText(quesWriteAnswer.get(i).get(1));
           if(quesWriteAnswer.get(i).size()!=2){
            int t = Integer.valueOf(quesWriteAnswer.get(i).get(1));
            for(int j=0;j<imageViewList.size();j++){   
                if(t==0)break;
                t--;
                im.setImage(quesWriteAnswer.get(i).get(2), imageViewList.get(j));
            }
        }
    }
    void choose(){
        if(r1.isSelected()) qz.mathGeoWriteAnswer();
        else if(r2.isSelected())qz.gkWriteAnswer();
        else qz.riddlesWriteAnswer();
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
        if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected())warn.setText("Please select one");
        else{
            choose();
            QuizHandle.load = true;
            gl.loadUI("tripWrite",borderpane);
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
        if(i==quesWriteAnswer.size()-1){
            next.setDisable(true);
            qz.clear();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        FunListController.centerOfEduCorner="quiz";
        if(QuizHandle.load){
             imageViewList.add(i1);
        imageViewList.add(i2);
        imageViewList.add(i3);
        imageViewList.add(i4);
        imageViewList.add(i5);
        imageViewList.add(i6);
        imageViewList.add(i7);
        imageViewList.add(i8);
            todo();
//            qz.loadTextColor(labelQues, next);
//            String red = qz.generateLightColor().toString().substring(17, 20);
//            String green = qz.generateLightColor().toString().substring(23, 26);
//            String blue = qz.generateLightColor().toString().substring(29, 32);
//            vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
//            next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");  
            if(quesWriteAnswer.size()==1){
                qz.clear();
                next.setDisable(true);
            }
        }
    }    
}
