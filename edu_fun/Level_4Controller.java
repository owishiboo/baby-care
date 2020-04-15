
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


public class Level_4Controller implements Initializable {

    @FXML
    private JFXButton light_green_1;
    @FXML
    private JFXButton light_green_2;
    @FXML
    private JFXButton light_green_3;
    @FXML
    private JFXButton dark_green_1;
    @FXML
    private JFXButton dark;
    @FXML
    private JFXButton dark_green_3;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Green_1(ActionEvent event) throws IOException {
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("OOPS_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }

    @FXML
    private void Green_2(ActionEvent event) throws IOException {
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("OOPS_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }

    @FXML
    private void Green_3(ActionEvent event) throws IOException {
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("OOPS_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }

    @FXML
    private void DGREEN_1(ActionEvent event) throws IOException {
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("OOPS_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }

    @FXML
    private void D_Green(ActionEvent event)  throws IOException{
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("Congrats_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }

    @FXML
    private void D_GREEN_3(ActionEvent event) throws IOException {
         Parent pane_level_4 = FXMLLoader.load(getClass().getResource("OOPS_4.fxml"));
        Scene scene_level_4 = new Scene(pane_level_4);
        Stage stage_level_4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_4.setScene(scene_level_4);
        stage_level_4.show();
    }
    
}
