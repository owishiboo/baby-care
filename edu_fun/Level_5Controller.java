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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alamgir
 */
public class Level_5Controller implements Initializable {

    @FXML
    private JFXButton planet_2;
    @FXML
    private JFXButton planet_1;
    @FXML
    private JFXButton planet_9;
    @FXML
    private JFXButton planet_8;
    @FXML
    private JFXButton planet_7;
    @FXML
    private JFXButton planet_6;
    @FXML
    private JFXButton planet_5;
    @FXML
    private JFXButton planet_4;
    @FXML
    private JFXButton planet_3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Venus(ActionEvent event) throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Mercury(ActionEvent event) throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Pluto(ActionEvent event) throws IOException{
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Neptune(ActionEvent event) throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Uranus(ActionEvent event) throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Saturn(ActionEvent event)  throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Jupiter(ActionEvent event) throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Mars(ActionEvent event)throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("OOPS_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Earth(ActionEvent event) throws IOException{
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("Congrats_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }
    
}
