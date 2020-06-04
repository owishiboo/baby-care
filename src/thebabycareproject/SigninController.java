package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import static thebabycareproject.LoginPageController.pass;

/**
 * Controller of ' signin ' (Basically gets the user's email and sends a code for verification).
 * Used for ' forgot password ' and ' create account ' both.
 * An email can't be used twice(sign up) and creating new password needs an account with a valid email.
 * Validates email, uses database to find out if we have the account and acts accordingly.
 * @author 2018331022(Owishi)
 */
public class SigninController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    static int flag=0; static String varification_code="";
    @FXML
    TextField email;
    @FXML
    Label label;
    
    /**
     * Loads ' Login Page '
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML 
    void goBack(ActionEvent event) throws IOException{
        gl.loadUI(event, "loginPage");      
    }
    
    /**
     * Checks if database has already an account created before with the given email and creates verification code
     * @param event ActionEvent
     * @throws Exception if email can't be sent
     */
    @FXML
    void signin(ActionEvent event) throws Exception {
        Validation valid = new Validation();
        if(email.getText().isEmpty())label.setText("Please enter your email");
        if(!valid.validateEmail(email))label.setText("Please enter a valid email");
        if(valid.validateEmail(email)){
            LoginPageController.email_txt = email.getText();
            Random random = new Random();
            int random_number = 999*(random.nextInt(109));
            varification_code=Integer.toString(random_number);
            flag=5;
            System.out.println(varification_code);
            if(pass){
                if(checkDB_without_pass(email))label.setText("The email is used before. Please enter an unused email.");
                else {
                    EmailUtil.sendMail(email.getText());
                    gl.loadUI(event, "verification");
                }
            }
            else{
                if(!checkDB_without_pass(email))label.setText("There is no account created by this email");
                else {
                    EmailUtil.sendMail(email.getText());
                    gl.loadUI(event, "verification");
                }
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 

    /**
     * Finds out if the account is valid(If email with the given password is found in database)
     * @param email email of user
     * @return boolean if the email was used before
     * @throws SQLException if the user database can't be found or connected 
     */
    boolean checkDB_without_pass(TextField email) throws SQLException{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM User WHERE email='"+email.getText()+"'";
            ResultSet result=statement.executeQuery(sql);
            if(result.next()){
                System.out.println("We have the account");
                return true;
            }
            else{
                System.out.println("WE don't have the account");
                return false;
            }
    }
}
