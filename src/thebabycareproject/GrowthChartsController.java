package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller of the section ' Growth Charts ' of the ' Growth &amp; Immunity ' category.
 * A list of pdfs of child growth and data about child growth surveys.
 * List can't be changed or deleted.
 * User should have google drive to read these pdf books.
 * @author 2018331022(Owishi)
 */
public class GrowthChartsController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    
    /**
     * Opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button1(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1LL5yyVBjy2LM4WwpQE7NrFljQwNwyTDv");
    }
    
    /**
     * Opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button2(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1E1JAibA6zOWVL5gqcpUPT_xbi7idLeWq");
    }
        
    /**
     * Opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button3(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1zt4RZu8AgBHRQnd89MlrAeGaW_trwIvl");
    }
        
    /**
     * Opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button4(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1UmCHm6oU00flt2QC12D6OCa2XGq0ZGta");
    }
        
    /**
     * Opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button5(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1gcH4qxFJMMTVJQgRELXeG-Pdgo66GveW");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
