package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controller of the section ' Vaccine Reminder ' of the ' Reminder &amp; Notifications ' category.
 * Sends a reminder as an email.
 * Email provided while creating account is the default recipient of the email.
 * The running day can't be chosen for sending email.
 * @author 2018331022(Owishi)
 */
public class VaccineReminderController implements Initializable {
    Validation valid = new Validation();
    static String date,year,month,day,mailAddress,email,time,hour,minute;
    @FXML DatePicker datePick;
    @FXML JFXTimePicker timePick;
    @FXML Label labelDate;
    @FXML VBox vbox;
    @FXML StackPane stackPane;
    
    /**
     * Provides informations about weight status
     * @param event ActionEvent
     */
    @FXML
    void clickHere(ActionEvent event){
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Ok, I got it!");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            
            dialog.close();
        });
        dialogLayout.setBody(new Text("Childhood vaccinations are important for your child. We\n" +
"have a special feature to make your task easier.\n" +
"So from now on don't forget to get the vaccines timely!\n" +
"\n" +
"Enter your date and preferred time to get an \n" +
"email-reminder.\n" +
"The receiver is the varified email address that you've used\n" +
"to sign up."));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        dialogLayout.setActions(ok);
        dialog.show();
        vbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        vbox.setEffect(null);
        });
    }
    
    /**
     * Calls method to create job to send email on valid date and time 
     * @param event ActionEvent
     * @throws Exception if the job can't be called
     */
    @FXML
    void initialize(ActionEvent event) throws Exception{
        LocalDate vaccineDate = datePick.getValue();
        if(datePick.getValue()==null)labelDate.setText("Please enter a date");
        else if(!valid.validateDateEmail(vaccineDate))labelDate.setText("Please enter a valid date");
        else if(timePick.getValue()==null)labelDate.setText("Please enter a time");
        else Main.main(null ); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePick.setOnAction((ActionEvent event) -> {
            date = datePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));//date to string
            System.out.println(date);
            year=String.valueOf(date.substring(0, 4));
            month=String.valueOf(date.substring(5, 7));
            day=String.valueOf(date.substring(8, 10));
            System.out.println(year+" "+month+" "+day);
        }); 
        timePick.setOnAction((ActionEvent event) -> {
            time = timePick.getValue().toString();//time to string
            System.out.println(time);
            hour=String.valueOf(time.substring(0, 2));
            minute=String.valueOf(time.substring(3, 5));
            System.out.println(hour+" "+minute);
        }); 
    }
   
    
}
