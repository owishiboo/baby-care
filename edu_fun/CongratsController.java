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
public class CongratsController implements Initializable {

    @FXML
    private JFXButton Menu;
    @FXML
    private JFXButton NEXT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GO_MAIN_MENU(ActionEvent event)throws IOException {
        Parent pane_main = FXMLLoader.load(getClass().getResource("Level_page.fxml"));
        Scene scene_main = new Scene(pane_main);
        Stage stage_main = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_main.setScene(scene_main);
        stage_main.show();
    }

    @FXML
    private void GO_NEXT(ActionEvent event)  throws IOException{
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("Level_2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }
    
}
