
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


public class OOPSController implements Initializable {

    @FXML
    private JFXButton reStart;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RESTARTING(ActionEvent event) throws IOException{
        Parent restartPane = FXMLLoader.load(getClass().getResource("Level_1.fxml"));
        Scene scene_re = new Scene(restartPane);
        Stage stage_re = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_re.setScene(scene_re);
        stage_re.show();
    }
    
}
