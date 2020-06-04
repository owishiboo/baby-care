package thebabycareproject;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import static thebabycareproject.SigninController.flag;

/**
 * Controller of the section ' Pop-ups ' of the ' Reminder &amp; Notifications ' category.
 * Creates message and sends email to user.
 * Users creates the body of email and chooses the sending time.
 * Email provided while creating account is the default recipient of the email.
 * The running day can't be chosen for sending email.
 * @author 2018331022(Owishi)
 */

public class Pop_upsController implements Initializable {
    Validation vd = new Validation();
    static String date2,year2,month2,day2,time2,hour2,minute2,body;
    @FXML DatePicker datePick;
    @FXML JFXTimePicker timePick;
    @FXML Label labelDate;
    @FXML JFXTextArea bodyOfMail;
    
    /**
     * Calls method to create job to send email on valid date and time with given email body
     * @param event ActionEvent
     * @throws Exception if the job can't be called
     */
    @FXML
    void initialize(ActionEvent event) throws Exception{
        LocalDate vaccineDate = datePick.getValue();
        if(datePick.getValue()==null)labelDate.setText("Please enter a date");
        else if(!vd.validateDateEmail(vaccineDate))labelDate.setText("Please enter a valid date");
        else if(timePick.getValue()==null)labelDate.setText("Please enter a time");
        else{
            flag=2;
            body = bodyOfMail.getText().replaceAll("\n", System.getProperty("line.separator"));
            Main2.main(null); 
        }
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePick.setOnAction((ActionEvent event) -> {
            date2 = datePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));//date to string
            System.out.println(date2);
            year2 =String.valueOf(date2.substring(0, 4));
            month2 =String.valueOf(date2.substring(5, 7));
            day2 =String.valueOf(date2.substring(8, 10));
            System.out.println(year2 + " " + month2 + " " + day2);
        }); 
        timePick.setOnAction((ActionEvent event) -> {
            time2 = timePick.getValue().toString();//time to string
            System.out.println(time2);
            hour2 = String.valueOf(time2.substring(0, 2));
            minute2 =String.valueOf(time2.substring(3, 5));
            System.out.println(hour2 + " " + minute2);
        }); 
    } 
}
