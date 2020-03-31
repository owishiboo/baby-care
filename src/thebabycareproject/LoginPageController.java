package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author hp
 */
public class LoginPageController implements Initializable {
    
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    Label noAccount;
    @FXML
    Label label;
    @FXML
    Label labelPass;
    @FXML
    @SuppressWarnings("empty-statement")
    public void signin(ActionEvent event) throws IOException {
        Validation valid = new Validation();
         if(email.getText().isEmpty())label.setText("Please enter your email");
         if(!valid.validateEmail(email))label.setText("Please enter a valid email");
         if(valid.validateEmail(email))label.setText("");
         if(password.getText().isEmpty())labelPass.setText("Please enter your password");
         if(!valid.validatePassword(password))labelPass.setText("Please enter password correctly");
         if(valid.validatePassword(password))labelPass.setText("");
         if(valid.validateEmail(email) && valid.validatePassword(password) && checkDB()==true){
            Parent pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            Scene home_page = new Scene(pane);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(home_page);
            stage.show(); ;
         }
         else if(!email.getText().isEmpty() && !password.getText().isEmpty() && !valid.validatePassword(password) && !valid.validateEmail(email)) {
             noAccount.setText("Please fill these fields correctly");
         }
    }
    @FXML
    private void signup(ActionEvent event) throws IOException {
         Parent pane = FXMLLoader.load(getClass().getResource("signin.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public boolean checkDB(){
        try{
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
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           return false;
        }
    }
}
