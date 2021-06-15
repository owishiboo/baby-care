package thebabycareproject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Used in many controllers.
 * Validates email, password(mainly length), text field as username(mainly length)
 * Email is validated differently for birthday of the child(must be in past) and sending email(must be in future).
 * @author 2018331022(Owishi)
 */
public class Validation {

    /**
     * Validates date
     * @param birthday user's input of birthday
     * @return boolean true if the given date is in the past
     */
    boolean validateDate(LocalDate birthday){
       Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return localDate.compareTo(birthday) > 0;
    }
    
    /**
     * Validates date
     * @param birthday user's input of birthday
     * @return boolean true if the given date is in future
     */
    boolean validateDateEmail(LocalDate birthday){
       Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return localDate.compareTo(birthday) < 0;
    }

    /**
     * Validates Email by the given pattern
     * @param txt_email user's given email address
     * @return boolean - validation of an email
     */
    boolean validateEmail(TextField txt_email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(txt_email.getText()); 
        return m.find() && m.group().equals(txt_email.getText());
    }

    /**
     * Validates password
     * @param password user's given password
     * @return boolean - if the password's length is more than 5
     */
    boolean validatePassword(PasswordField password){
        return password.getText().length()>5;
    }

    /**
     * Validates date
     * @param name user's given name
     * @return boolean - if the name's length is more than 5
     */
    boolean validateName(TextField name){

        return name.getText().length() >5;
        }
    }
