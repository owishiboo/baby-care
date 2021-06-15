package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static thebabycareproject.LoginPageController.pass;
import static thebabycareproject.SigninController.varification_code;

/**
 * Controller of ' verification ' (Basically matches the code given by the user and previously generated verification code).
 * Used for creating account and verifying old account in case user forgot the password.  
 * @author 2018331022(Owishi)
 */
public class VerificationController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML
    TextField code;
    @FXML
    Label verification_label;
    
    /**
     * 
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML 
    void goBack(ActionEvent event) throws IOException{
        gl.loadUI(event, "signin");    
    }
    
    /**
     * 
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML 
    void verify(ActionEvent event) throws IOException{
        if(code.getText().equals(varification_code) && pass) {
            gl.loadUI(event, "profile");   
        }
        else if(code.getText().equals(varification_code) && !pass) {
            gl.loadUI(event, "forgotPass");   
        }
        else verification_label.setText("Your code is wrong");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
