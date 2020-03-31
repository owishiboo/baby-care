
package thebabycareproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

public class Validation {
    public boolean validateDate(String date){
        Date dateToday = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String dateTodayString = dateFormat.format(dateToday);   
        return date.compareTo(dateTodayString) <= 0;
    }
    public boolean validateEmail(TextField txt_email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(txt_email.getText()); 
        if(m.find() && m.group().equals(txt_email.getText())){
            return true;
        }
        else return false;
    }
    public boolean validatePassword(TextField password){
        return password.getText().length()>=6;
    }
}
