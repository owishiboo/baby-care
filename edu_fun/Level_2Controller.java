
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Level_2Controller implements Initializable {

    @FXML
    private JFXButton Circle_1;
    @FXML
    private JFXButton tri;
    @FXML
    private JFXButton Penta_1;
    @FXML
    private JFXButton Circle_3;
    @FXML
    private JFXButton Hexa_3;
    @FXML
    private JFXButton Penta_2;
    @FXML
    private JFXButton Circle_4;
    @FXML
    private JFXButton Penta_3;
    @FXML
    private ImageView Circle_2;
    @FXML
    private ImageView Penta_4;
    @FXML
    private JFXButton Penta;
    @FXML
    private JFXButton Hexa_2;
    @FXML
    private JFXButton Hexa_1;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Click_cir_1(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_Tri(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("Congrats_2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_penta_1(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_circle_3(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_hexa_3(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_penta_2(ActionEvent event) throws IOException{
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_circle_4(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_penta_3(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_circle_2(MouseEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_penta(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_hexa_2(ActionEvent event) throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }

    @FXML
    private void Click_hexa_1(ActionEvent event)throws IOException {
        Parent pane_level_2 = FXMLLoader.load(getClass().getResource("OOPS2.fxml"));
        Scene scene_level_2 = new Scene(pane_level_2);
        Stage stage_level_2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level_2.setScene(scene_level_2);
        stage_level_2.show();
    }
    
}
