package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller of the section ' Care Playlist ' of the ' Growth &amp; Immunity ' category.
 * Provides ideas about child growth and cautions via created youtube video list .
 * List can't be changed or deleted.
 * @author 2018331022(Owishi)
 */
public class CareCornerController implements Initializable {
    GoAndLoad gl = new GoAndLoad();

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button1(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/auISvRDHo3g");
    }

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button2(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/__exjqopG44");
    }

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button3(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/-CWJYxIvoFQ");
    }

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button4(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/0tcXN6C3y6I");
    }

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button5(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/gIZ8PkLMMUo");
    }

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button6(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/UtGqRVIKg4U");
    }

    /**
     * plays suggested youtube video
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button7(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/TapeBriMc8s");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
