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
public class Level_3Controller implements Initializable {

    @FXML
    private JFXButton Lion;
    @FXML
    private JFXButton tiger;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Go_Lion(ActionEvent event) throws IOException {
        Parent pane_level_3 = FXMLLoader.load(getClass().getResource("OOPS3.fxml"));
        Scene scene_level_3 = new Scene(pane_level_3);
        Stage stage_level_3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_3.setScene(scene_level_3);
        stage_level_3.show();
    }

    @FXML
    private void Go_Tiger(ActionEvent event)throws IOException {
        Parent pane_level_3 = FXMLLoader.load(getClass().getResource("Congrats_3.fxml"));
        Scene scene_level_3 = new Scene(pane_level_3);
        Stage stage_level_3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_3.setScene(scene_level_3);
        stage_level_3.show();
    }
    
}
