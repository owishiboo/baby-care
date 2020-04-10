
package thebabycareproject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Validation {
    public boolean validateDate(LocalDate birthday){
       Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return localDate.compareTo(birthday) >= 0;
    }
    public boolean validateEmail(TextField txt_email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(txt_email.getText()); 
        return m.find() && m.group().equals(txt_email.getText());
    }
    public boolean validatePassword(PasswordField password){
        return password.getText().length()>=6;
    }
    public boolean validateName(TextField name){

        return name.getText().length() >= 6;
        }
    }
