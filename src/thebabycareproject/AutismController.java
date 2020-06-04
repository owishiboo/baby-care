package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

/**
 * Controller of the section 'Autism' of the ' Growth &amp; Immunity ' category.
 * Provides ideas about autism via shared web blogs and pages. 
 * @author 2018331022(Owishi)
 */
public class AutismController implements Initializable {
    @FXML Hyperlink h1,h2,h3,h4;
    GoAndLoad gl = new GoAndLoad();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        h1.setOnAction((ActionEvent event) -> {
            try {
                gl.go_to("https://www.cdc.gov/ncbddd/autism/facts.html");
            } catch (IOException ex) {
                Logger.getLogger(AutismController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        h2.setOnAction((ActionEvent event) -> {
            try {
                gl.go_to("https://www.webmd.com/brain/autism/understanding-autism-basics");
            } catch (IOException ex) {
                Logger.getLogger(AutismController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        h3.setOnAction((ActionEvent event) -> {
            try {
                gl.go_to("https://www.autismspeaks.org/world-autism-awareness-day");
            } catch (IOException ex) {
                Logger.getLogger(AutismController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        h4.setOnAction((ActionEvent event) -> {
            try {
                gl.go_to("https://www.autism-society.org/");
            } catch (IOException ex) {
                Logger.getLogger(AutismController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
