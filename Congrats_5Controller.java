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
public class Congrats_5Controller implements Initializable {

    @FXML
    private JFXButton Main_menu;
    @FXML
    private JFXButton next_level;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Main__menu(ActionEvent event) throws IOException {
        Parent pane_level = FXMLLoader.load(getClass().getResource("Level_page.fxml"));
        Scene scene_level = new Scene(pane_level);
        Stage stage_level = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level.setScene(scene_level);
        stage_level.show();
    }

    @FXML
    private void GO_next_6(ActionEvent event) throws IOException {
        Parent pane_level_6 = FXMLLoader.load(getClass().getResource("Level_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }
    
}
