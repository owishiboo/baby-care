
package edu_fun;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private JFXButton button_Start;
    @FXML
    private JFXButton go_Back;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void START(ActionEvent event) throws IOException {
        Parent p1 = FXMLLoader.load(getClass().getResource("Level_page.fxml"));
        Scene scene_level = new Scene(p1);
        Stage stage_level = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage_level.setScene(scene_level);
        stage_level.show();
        
        
        
        
    }
    

    @FXML
    private void GO_BACK(ActionEvent event) {
    }

    
    
}
