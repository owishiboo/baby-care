package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class FunListController implements Initializable {
    @FXML
    BorderPane borderpane;
    @FXML
    public void goBack(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();      
    }
    @FXML
    public void care_corner(ActionEvent event){
        loadUI("careCorner");
    }
    @FXML
    public void fun_learn(ActionEvent event){
        loadUI("funAndLearn");
    }
    @FXML
    public void create_playlist(ActionEvent event){
        loadUI("createPlaylist");
    }
    void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FunListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadUI("careCorner");
    }    
    
}
