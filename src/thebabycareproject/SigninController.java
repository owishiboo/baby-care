package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class SigninController implements Initializable {
    public static int flag=0;public static String varification_code="";
    @FXML
    TextField email;
    @FXML
    Label label;
     @FXML 
    public void goBack(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();      
    }
    @FXML
    @SuppressWarnings("empty-statement")
    private void signin(ActionEvent event) throws IOException, Exception {
        Validation valid = new Validation();
        
         if(email.getText().isEmpty())label.setText("Please enter your email");
         if(!valid.validateEmail(email))label.setText("Please enter a valid email");
         if(valid.validateEmail(email)){
            LoginPageController.email_txt=email.getText();
            Random random = new Random();
            int random_number = 999*(random.nextInt(109));
            varification_code=Integer.toString(random_number);
            flag=5;
            System.out.println(varification_code);
            if(checkDB_without_pass(email))label.setText("The email is used before. Please enter an unused email.");
            else {
                //label.setText("Please wait, a verification code is being sent in your account.");                
                EmailUtil.sendMail(email.getText());
                Parent pane = FXMLLoader.load(getClass().getResource("verification.fxml"));
                Scene home_page = new Scene(pane);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(home_page);
                stage.show(); ;
            }
         }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    public boolean checkDB_without_pass(TextField email){
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
