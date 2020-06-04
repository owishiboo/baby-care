package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import static thebabycareproject.CreatePlaylistController.*;

/**
 * Controller of the subsection ' Playlist form ' of the section ' Create Playlist ' of the ' Edu-corner ' category.
 * Saves provided address in database and changes the list.
 * @author 2018331022(Owishi)
 */
public class PlaylistFormController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML TextField name,httpsurl;
    @FXML Label label;
    @FXML StackPane stackPane;
    @FXML VBox vbox;
    static String nameForPlaylist="+",urlForPlaylist="+";
    
    /**
     * Shows a dialog box and warns about the undone changes, may load a new fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void goBack(ActionEvent event) throws IOException{
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Ok");
        JFXButton cancel = new JFXButton("Cancel");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            try {
                gl.loadUI(event, "funList");
            } catch (IOException ex) {
                Logger.getLogger(PlaylistFormController.class.getName()).log(Level.SEVERE, null, ex);
            }  
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
    
    /**
     * Saves new file in the playlist
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     * @throws SQLException if the user database can't be connected or found
     */
    @FXML 
    void  save(ActionEvent event) throws IOException, SQLException{
        if(name.getText().isEmpty() || httpsurl.getText().isEmpty())label.setText("Fields cannot be empty");
        else if(name.getText().length()>400)label.setText("Name can't contain more than 400 characters(with space)");
        else if(httpsurl.getText().length()>1000)label.setText("URL can't contain more than 1000 characters");
        else{
        nameForPlaylist = name.getText();
        urlForPlaylist = httpsurl.getText();
        insertDB_(position);
        gl.loadUI(event, "funList");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  

    /**
     * Insert new HTTPS url in database(mainly updates the database)
     * @param pos index
     * @throws SQLException if the user database can't be connected or found
     */
    void insertDB_(int pos) throws SQLException{
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
                ) {
            System.out.println("Connected");
            String sqlPlaylist = "update playlist set p"+pos+"=? , s"+pos+"=? where email=?";
            try (PreparedStatement statement = connection.prepareStatement(sqlPlaylist)) {
                System.out.println("name for playlist = "+nameForPlaylist);
                statement.setString(1,urlForPlaylist);
                statement.setString(2,nameForPlaylist);
                statement.setString(3,LoginPageController.email_txt);
                statement.executeUpdate();
                System.out.println("Done inserting "+pos+" song");
            }
        }
            System.out.println("Done");
    } 
}
