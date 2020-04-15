package thebabycareproject;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
public class FunAndLearnController implements Initializable {
    @FXML 
    public void button1(ActionEvent event) throws URISyntaxException, IOException{
            go_to("https://youtu.be/75p-N9YKqNo");
    }
    @FXML 
    public void button2(ActionEvent event) throws URISyntaxException, IOException{
            go_to("https://youtu.be/51aaWhfnzNQ");
    }
    @FXML 
    public void button3(ActionEvent event) throws URISyntaxException, IOException{
            go_to("https://youtu.be/3pkmuS73cv8");
    }
    public void go_to(String site) throws IOException{
        try {
            Desktop.getDesktop().browse(new URI(site));
        } catch (URISyntaxException e1) {
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
