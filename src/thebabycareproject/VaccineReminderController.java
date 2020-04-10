package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
        });       
    }
    public boolean validateDate(){
        Date dateToday = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String dateTodayString = dateFormat.format(dateToday);   
        return date.compareTo(dateTodayString) < 0;
    }
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
        if(datePick.getValue()==null)labelDate.setText("Please enter a date");
        //else if(!validateDate())labelDate.setText("Please enter a valid date");
        else{
            Main.main(null );
        }
    }
   
    
}
