package thebabycareproject;
import com.jfoenix.controls.JFXTimePicker;
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
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;
public class VaccineReminderController implements Initializable {
    public static String date,year,month,day,mailAddress,email,time,hour,minute;
    @FXML 
    public DatePicker datePick;
    @FXML
    JFXTimePicker timePick;
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
        timePick.setOnAction((ActionEvent event) -> {
            time = timePick.getValue().toString();//time to string
            System.out.println(time);
            hour=String.valueOf(time.substring(0, 2));
            minute=String.valueOf(time.substring(3, 5));
            System.out.println(hour+" "+minute);
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
        else if(!validateDate())labelDate.setText("Please enter a valid date");
        else{
            Image icon = new Image("/image/icon.png");
            TrayNotification trayBefore = new TrayNotification();
            trayBefore.setTitle("Please wait...");
            trayBefore.setImage(icon);
            trayBefore.setRectangleFill(Paint.valueOf("#42070B"));
            trayBefore.setMessage("It may a few minutes");
            trayBefore.setAnimationType(AnimationType.FADE);
            trayBefore.showAndDismiss(Duration.seconds(2));
            Main.main(null ); 
        }
    }
   
    
}
