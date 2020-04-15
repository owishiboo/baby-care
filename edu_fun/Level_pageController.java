
package edu_fun;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Level_pageController implements Initializable {

    @FXML
    private JFXButton Level_1;
    @FXML
    private JFXButton Level_2;
    @FXML
    private JFXButton Level_3;
    @FXML
    private JFXButton Level_4;
    @FXML
    private JFXButton Level_5;
    @FXML
    private JFXButton Level_6;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Go_1(ActionEvent event) throws IOException{
        Parent pane_level_1 = FXMLLoader.load(getClass().getResource("Level_1.fxml"));
        Scene scene_level_1 = new Scene(pane_level_1);
        Stage stage_level_1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_1.setScene(scene_level_1);
        stage_level_1.show();
    }

    @FXML
    private void Go_2(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("Level_2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Go_3(ActionEvent event) throws IOException {
         Parent pane_level_3 = FXMLLoader.load(getClass().getResource("Level_3.fxml"));
        Scene scene_level_3 = new Scene(pane_level_3);
        Stage stage_level_3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_3.setScene(scene_level_3);
        stage_level_3.show();
    }

    @FXML
    private void Go_4(ActionEvent event) throws IOException {
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("Level_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }

    @FXML
    private void Go_5(ActionEvent event) throws IOException {
        Parent pane_level_5 = FXMLLoader.load(getClass().getResource("Level_5.fxml"));
        Scene scene_level_5 = new Scene(pane_level_5);
        Stage stage_level_5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_5.setScene(scene_level_5);
        stage_level_5.show();
    }

    @FXML
    private void Go_6(ActionEvent event)  throws IOException {
         Parent pane_level_6 = FXMLLoader.load(getClass().getResource("Level_6.fxml"));
        Scene scene_level_6 = new Scene(pane_level_6);
        Stage stage_level_6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_6.setScene(scene_level_6);
        stage_level_6.show();
    }
    
}
