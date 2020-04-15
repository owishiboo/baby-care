package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static thebabycareproject.CreatePlaylistController.*;
public class PlaylistFormController implements Initializable {
    @FXML TextField name,httpsurl;
    @FXML Label label;
    @FXML StackPane stackPane;
    @FXML VBox vbox;
    public static String nameForPlaylist="+",urlForPlaylist="+";
    @FXML 
    public void  save(ActionEvent event) throws IOException{
        if(name.getText().isEmpty() || httpsurl.getText().isEmpty())label.setText("Fields cannot be empty");
        else{
        nameForPlaylist = name.getText();
        urlForPlaylist = httpsurl.getText();
        urlString[position]=urlForPlaylist;
        nameString[position]=nameForPlaylist;
        Parent pane = FXMLLoader.load(getClass().getResource("funList.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();  
        }
    }
    @FXML
    public void goBack(ActionEvent event) throws IOException{
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Ok");
        JFXButton cancel = new JFXButton("Cancel");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            switcharr[position]=0;position=-1;
               Parent pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("funList.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(PlaylistFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();  
        });
        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            dialog.close();
        });
        dialogLayout.setBody(new Text("Your playlist will be undone"));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        cancel.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18px;");
        dialogLayout.setActions(ok,cancel);
        dialog.show();
        vbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
            vbox.setEffect(null);
        });
             
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
