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
public class OOPS2Controller implements Initializable {

    @FXML
    private JFXButton Restart_again;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Restarting(ActionEvent event) throws IOException {
        Parent pane_restart_2 = FXMLLoader.load(getClass().getResource("Level_2.fxml"));
        Scene scene_restart_2 = new Scene(pane_restart_2);
        Stage stage_restart_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_restart_2.setScene(scene_restart_2);
        stage_restart_2.show();
    }
    
}
