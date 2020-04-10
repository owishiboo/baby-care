package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;
public class LoginPageController implements Initializable {
    
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    Label noAccount;
    @FXML
    Label label;
    @FXML
    Label labelPass;
    @FXML
    @SuppressWarnings("empty-statement")
    public static String email_txt;
    public void signin(ActionEvent event) throws IOException {
        Validation valid = new Validation();
        if(!checkDB_with_pass(email,password) && !password.getText().isEmpty() && !email.getText().isEmpty())noAccount.setText("You don't have any account");
        //if(!checkDB_with_pass(email))label.setText("Please enter the fields correctly");
        if(email.getText().isEmpty())label.setText("Please enter your email");
        if(valid.validateEmail(email))label.setText("");
        if(password.getText().isEmpty())labelPass.setText("Please enter your password");
        if(valid.validatePassword(password))labelPass.setText("");
        if(valid.validateEmail(email) && valid.validatePassword(password) && checkDB_with_pass(email,password)==true){
                String title = "";
                String message = "Welcome to baby care!";       
                Image icon = new Image("/image/icon.png");
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setAnimationType(AnimationType.FADE);
                tray.setImage(icon);
                tray.setRectangleFill(Paint.valueOf("#42070B"));
                tray.setMessage(message);
                tray.showAndDismiss(Duration.seconds(2));
             email_txt=email.getText();
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
    public boolean checkDB_with_pass(TextField email, PasswordField password){
        try{
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
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           return false;
        }
    }
}
