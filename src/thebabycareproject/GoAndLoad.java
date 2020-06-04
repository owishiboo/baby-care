package thebabycareproject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * Used in various controller.
 * Visits webpages(HTTPS only).
 * Loads new fxml in a new stage(ActionEvent and MouseEvent) or in the center of borderpane.
 * Loads music(welcome tune).
 * Creates tray notifications with certain message.
 * @author 2018331022(Owishi)
 */
public class GoAndLoad {
    
    /**
     * Uses default browser to load new url
     * must be a HTTPS address
     * @param s url address
     * @throws IOException if site isn't HTTPS address
     */
    void go_to(String s) throws IOException{
        try {
            Desktop.getDesktop().browse(new URI(s));
        } catch (URISyntaxException e1) {
        }
    }
    
    /**
     * Loads fxml in the center of border pane
     * @param s name of the fxml
     * @param borderpane parent pane
     */
    void loadUI(String s, BorderPane borderpane){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(s+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FunListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);
    }
    
    /**
     * Loads new fxml to a new stage for actionEvent
     * @param event ActionEvent
     * @param s name of the fxml
     * @throws IOException if fxml isn't found
     */
    void loadUI(ActionEvent event, String s) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(s+".fxml"));
        Scene home_page = new Scene(pane);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxHeight(600);
        stage.setMaxWidth(800);
        stage.setTitle("Baby Care");
        stage.setScene(home_page);
        stage.show();    
    }
    
    /**
     * loads new fxml to a new stage for mouseEvent
     * @param event MouseEvent
     * @param s name of the fxml
     * @throws IOException if fxml isn't found
     */
    void loadUI(MouseEvent event, String s) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(s+".fxml"));
        Scene home_page = new Scene(pane);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxHeight(600);
        stage.setMaxWidth(800);
        stage.setScene(home_page);
        stage.show();    
    }
    
    /**
     * Loads sound
     * Used as a welcome tune
     */
    void setMusic(){
        String path = "src/sound/notification.mp3";  
        Media media = new Media(new File(path).toURI().toString());  
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }
    
    /**
     * Creates tray notification
     * @param title heading of the notification
     * @param message body of the notification
     */
    void notification(String title, String message){
            Image icon = new Image("/image/icon.png");
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setImage(icon);
            tray.setRectangleFill(Paint.valueOf("#42070B"));
            tray.setMessage(message);
            tray.showAndDismiss(Duration.seconds(2));
    }    
}
