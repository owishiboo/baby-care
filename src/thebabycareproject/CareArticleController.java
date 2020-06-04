package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller of the section ' Care Blogs ' of the ' Growth &amp; Immunity ' category.
 * Provides ideas about child growth and cautions via shared web blogs and pages.
 * List can't be changed or deleted.
 * @author 2018331022(Owishi).
 */
public class CareArticleController implements Initializable {
    GoAndLoad gl = new GoAndLoad();

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button1(ActionEvent event) throws IOException{
        gl.go_to("https://www.whattoexpect.com/first-year/month-by-month/");
    }

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button2(ActionEvent event) throws IOException{
        gl.go_to("https://www.adam-mila.com/brain-development-children-0-6-years/");
    }

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button3(ActionEvent event) throws IOException{
        gl.go_to("https://www.stanfordchildrens.org/en/topic/default?id=age-appropriate-speech-and-hearing-milestones-90-P02169");
    }

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button4(ActionEvent event) throws IOException{
        gl.go_to("https://www.pediatricdentalofwayland.com/blog/kids-dental-development-timeline/");
    }

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button5(ActionEvent event) throws IOException{
        gl.go_to("https://www.chrichmond.org/therapy-services/occupational-therapy/developmental-milestones/gross-motor-skills-birth-to-5-years");
    }

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button6(ActionEvent event) throws IOException{
        gl.go_to("https://www.parents.com/health/the-10-most-common-childhood-illnesses/");
    }

    /**
     * visits website
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button7(ActionEvent event) throws IOException{
        gl.go_to("https://raisingchildren.net.au/babies/play-learning/active-play/physical-activity-for-young-children#physical-activity-for-children-0-2-years-nav-title");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
