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
import javafx.stage.Stage;
public class HomePageController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    @FXML
    public void foodChart(ActionEvent event) throws IOException{
        Parent paneFoodChart = FXMLLoader.load(getClass().getResource("foodChart.fxml"));
         Scene sceneFoodChart = new Scene(paneFoodChart);
         Stage stageFoodChart = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stageFoodChart.setScene(sceneFoodChart);
         stageFoodChart.show();
    }
    public void bmi(ActionEvent event) throws IOException{
        Parent panebmi = FXMLLoader.load(getClass().getResource("getbmi.fxml"));
         Scene scenebmi = new Scene(panebmi);
         Stage stagebmi = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stagebmi.setScene(scenebmi);
         stagebmi.show();
    }
    
    public void vaccineReminder(ActionEvent event) throws IOException{
        Parent panevaccine = FXMLLoader.load(getClass().getResource("VaccineReminder.fxml"));
         Scene scenevaccine = new Scene(panevaccine);
         Stage stagevaccine = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stagevaccine.setScene(scenevaccine);
         stagevaccine.show();
    }
    public void funList(ActionEvent event) throws IOException{
        Parent paneFunList = FXMLLoader.load(getClass().getResource("funList.fxml"));
         Scene sceneFunList = new Scene(paneFunList);
         Stage stageFunList = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stageFunList.setScene(sceneFunList);
         stageFunList.show();
    }
}
