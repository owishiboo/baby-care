package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
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
        Parent panevaccine = FXMLLoader.load(getClass().getResource("vaccineReminder.fxml"));
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
    @FXML
    void logOut(ActionEvent event) throws IOException{
       Parent pane = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();
    }
    @FXML
    void profile_settings(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("profile.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();
    }
}
