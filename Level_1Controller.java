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


public class Level_1Controller implements Initializable {

    @FXML
    private JFXButton button_1;
    @FXML
    private JFXButton button_2;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Message_1(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("OOPS.fxml"));
        Scene scene_l = new Scene(p);
        Stage stage_l = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_l.setScene(scene_l);
        stage_l.show();
    }

    @FXML
    private void Message_2(ActionEvent event) throws IOException {
        Parent pane_congo = FXMLLoader.load(getClass().getResource("Congrats.fxml"));
        Scene scene_congo = new Scene(pane_congo);
        Stage stage_congo = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_congo.setScene(scene_congo);
        stage_congo.show();
    }
    
}
