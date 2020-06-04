package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * Controller of Login page(Initial fxml).
 * Has ' sign in '(if user has created account) ' sign up '(to create account) and ' forgot Password '
 * (created account but doesn't remember password) features.
 * Email and password are needed to sign in.
 * Email needed to sign up and get new password.
 * Uses local database to save and match email and password of the user.
 * @author 2018331022(Owishi)
 */
public class LoginPageController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML TextField email;
    @FXML PasswordField password;
    @FXML Label noAccount;
    @FXML Label label;
    @FXML Label labelPass;
    static String email_txt;
    static boolean pass=true;

    /**
     * Loads ' Home Page ' if given password and email are found in database 
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     * @throws SQLException if the user database can't be connected or found
     */
    @FXML
    void signin(ActionEvent event) throws IOException, SQLException {
        pass=true;
        Validation valid = new Validation();
        if(!checkDB_with_pass(email,password) && !password.getText().isEmpty() && !email.getText().isEmpty())noAccount.setText("Please enter the fields correctly");
        if(email.getText().isEmpty())label.setText("Please enter your email");
        if(valid.validateEmail(email))label.setText("");
        if(password.getText().isEmpty())labelPass.setText("Please enter your password");
        if(valid.validatePassword(password))labelPass.setText("");
        if(valid.validateEmail(email) && valid.validatePassword(password) && checkDB_with_pass(email,password)==true){
            email_txt=email.getText();
            gl.notification("", "Welcome to baby care!");
            gl.loadUI(event, "homePage");
            gl.setMusic();
         }
         else if(!email.getText().isEmpty() && !password.getText().isEmpty() && !valid.validatePassword(password) && !valid.validateEmail(email)) {
             noAccount.setText("Please fill these fields correctly");
         }
    }
    
    /**
     * To create new account
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void signup(ActionEvent event) throws IOException {
        pass=true;
        gl.loadUI(event, "signin");
    }
    
    /**
     * To set new password in case the user forgets password 
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */
    @FXML
    void forgotPass(ActionEvent event) throws IOException{
        pass = false;
        gl.loadUI(event, "signin");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    /**
     * Finds out if the account is valid(If email with the given password is found in database)
     * @param email given email by user
     * @param password password of user
     * @return boolean true if the given email and password are registered before
     * @throws SQLException if the user database can't be connected or found
     */
    boolean checkDB_with_pass(TextField email, PasswordField password) throws SQLException{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM User WHERE email='"+email.getText()+"' and password='"+password.getText()+"'";
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
