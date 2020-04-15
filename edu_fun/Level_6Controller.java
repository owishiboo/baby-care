/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu_fun;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Alamgir
 */
public class Level_6Controller implements Initializable {

    @FXML
    private Circle circle_yellow;
    @FXML
    private Circle circle_blue;
    @FXML
    private Circle circle_green;
    @FXML
    private Circle circle_purple;
    @FXML
    private Circle circle_4;
    @FXML
    private JFXButton Play_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Blue(MouseEvent event) throws IOException {
         Parent pane_level_6 = FXMLLoader.load(getClass().getResource("OOPS_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }

    @FXML
    private void Green(MouseEvent event) throws IOException {
         Parent pane_level_6 = FXMLLoader.load(getClass().getResource("OOPS_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }

    @FXML
    private void Purple(MouseEvent event) throws IOException {
         Parent pane_level_6 = FXMLLoader.load(getClass().getResource("Congrats_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }

    @FXML
    private void circle_light_green(MouseEvent event) throws IOException {
         Parent pane_level_6 = FXMLLoader.load(getClass().getResource("OOPS_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }

    @FXML
    private void Yellow(MouseEvent event) throws IOException{
         Parent pane_level_6 = FXMLLoader.load(getClass().getResource("OOPS_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }
    
    private void setRotate(Circle c,boolean reverse,int angle ,int duration){
        RotateTransition rt = new RotateTransition(Duration.seconds(duration),c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
       // rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(20);
        rt.play();
        
        
        
    }

    @FXML
    private void button(ActionEvent event) {
        setRotate(circle_yellow,true,360,20);
        setRotate(circle_blue,true,360,15);
        setRotate(circle_purple,true,360,5);
        setRotate(circle_green,true,360,9);
        setRotate(circle_4,true,360,12);
        
    }
    
}
