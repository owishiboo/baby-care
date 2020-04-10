/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebabycareproject;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static thebabycareproject.SigninController.varification_code;
public class VerificationController implements Initializable {
    @FXML
    TextField code;
    @FXML
    Label label;
    @FXML 
    public void goBack(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("signin.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();      
    }
    @FXML 
    public void verify(ActionEvent event) throws IOException{
        //if(code.getText().equals(varification_code)) {
            Parent pane = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Scene home_page = new Scene(pane);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(home_page);      
            stage.show();
        //} else label.setText("Your code is wrong");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
