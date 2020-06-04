package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller of the section ' Fun and Learn ' of the ' Edu-care ' category.
 * A youtube playlist for pre-school kids to learn about alphabets, colors etc.
 * List can't be changed or deleted.
 * @author 2018331022(Owishi)
 */
public class FunAndLearnController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button1(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/75p-N9YKqNo");
    }
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button2(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/51aaWhfnzNQ");
    }
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button3(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/3pkmuS73cv8");
    }
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button4(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/NBuA6YIQHCs");
    }
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button5(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/glkQwKA5_PU");
    }
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button6(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/VxBEmaaSh1c");
    }
    
    /**
     * Loads given HTTPS url
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void button7(ActionEvent event) throws IOException{
            gl.go_to("https://youtu.be/gghDRJVxFxU");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
