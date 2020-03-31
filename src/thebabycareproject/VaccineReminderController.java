package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
public class VaccineReminderController implements Initializable {
    public static String date;
    public static String year,month,day;
    public static String mailAddress;
    public static String email;
    @FXML 
    public DatePicker datePick;
    @FXML
    public Label label;
    @FXML
    public Label labelDate;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePick.setOnAction((ActionEvent event) -> {
            date = datePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));//date to string
            System.out.println(date);
            year=String.valueOf(date.substring(0, 4));
            month=String.valueOf(date.substring(5, 7));
            day=String.valueOf(date.substring(8, 10));
            System.out.println(year+" "+month+" "+day);
            validateEmail();
        });       
    }
    
    @FXML 
    public TextField txt_email;
    public boolean validateEmail(){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(txt_email.getText()); 
        if(m.find() && m.group().equals(txt_email.getText())){
            return true;
        }
        else return false;
        //return p.matcher((CharSequence) txt_email).matches(); 
    }
//    public boolean validateDate(){
//        Date dateToday = Calendar.getInstance().getTime();  
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
//        String dateTodayString = dateFormat.format(dateToday);   
//        return date.compareTo(dateTodayString) < 0;
//    }
    @FXML
    public void goBack(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();      
    }
    @FXML
    public void initialize(ActionEvent event) throws IOException, Exception{
        
        if(!validateEmail())label.setText("Please enter a valid email");
        if (txt_email.getText().isEmpty())label.setText("Please enter an email");
        if(datePick.getValue()==null)labelDate.setText("Please enter a date");
        //else if(!validateDate())labelDate.setText("Please enter a valid date");
        else{
            label.setText("");
            email = txt_email.getText();
            Main.main(null );
            //EmailUtil.sendMail(email);
        }
        
    }
   
    
}
