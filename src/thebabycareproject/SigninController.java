package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import static thebabycareproject.VaccineReminderController.date;
//eta sign up er jonne , login na hole hobe
public class SigninController implements Initializable {
    
    @FXML
    TextField email;
    @FXML
    Label label;
    @FXML
    DatePicker birthday;
    @FXML
    Label labelDate;
     @FXML
    TextField password;
     @FXML
    Label labelPass;
     @FXML
    public void goBack(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();      
    }
    @FXML
    private void signup(ActionEvent event) throws IOException {
        Validation valid = new Validation();
         if(email.getText().isEmpty())label.setText("Please enter your email");
         if(!valid.validateEmail(email))label.setText("Please enter a valid email");
         if(password.getText().isEmpty())labelPass.setText("Please enter your password");
         if(!valid.validatePassword(password))labelPass.setText("Your password must contain 6 or more characters");
         String date = birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         if(date.isEmpty())labelDate.setText("Please enter birthday");
         if(valid.validateDate(date)) {
        } else {
             labelDate.setText("Please enter a valid date");
        }
         if(valid.validateEmail(email) && valid.validatePassword(password) && valid.validateDate(date)){
            insertDB();
            Parent pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            Scene home_page = new Scene(pane);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(home_page);
            stage.show(); ;
         }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void insertDB(){
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
            ) {
                System.out.println("Connected");
                String emailsql = email.getText();
                String birthdaysql= birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String passwordsql=password.getText();
                String sql = "insert into User (email,birthday,password) values(?,?,?)";
                PreparedStatement  statement = connection.prepareStatement(sql);
                statement.setString(1,emailsql);System.out.println("Done inserting email");
                statement.setString(2,birthdaysql);System.out.println("Done inserting birthday");
                statement.setString(3,passwordsql);System.out.println("Done inserting password");
                statement.executeUpdate();
                statement.close();
            }
            System.out.println("Done");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }   
}
