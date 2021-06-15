package thebabycareproject;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import static thebabycareproject.PlaylistFormController.nameForPlaylist;

/**
 * Changes password if user forgets his old password.
 * Basically updates the previous password in database.
 * Password can't be showed, password will be updated only if both password fields match.
 * @author 2018331022(Owishi)
 */
public class ForgotPassController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML PasswordField password,re_password;
    @FXML Label profile_label,welcome_label;
    
    /**
     * Changes password after validation
     * @param event ActionEvent
     * @throws Exception if fxml not found
     */
    @FXML
    void save(ActionEvent event) throws Exception {
        Validation valid = new Validation();
            if(!valid.validatePassword(password))profile_label.setText("Password must contain 6 or more letters");
            else if(!password.getText().equals(re_password.getText()))profile_label.setText("The password fields don't match");
            else if(password.getText().equals(re_password.getText())){
                changeDB();                
                gl.loadUI(event, "homePage");
                gl.setMusic();
                gl.notification("Hey!", "You're  password was changed");
         }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            welcome_label.setText("Welcome back, "+getDB()+"!");
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * updates database with new data
     */
    void changeDB(){
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
            ) {
                System.out.println("Connected");
                String sqlPlaylist = "update user set password=? where email=?";
                try (PreparedStatement statement = connection.prepareStatement(sqlPlaylist)) {
                    System.out.println("name for playlist = "+nameForPlaylist);
                    statement.setString(1,password.getText());
                    statement.setString(2,LoginPageController.email_txt);
                    statement.executeUpdate();
                    System.out.println("Done changing  password");
                    
                }
            }
            System.out.println("Done");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * collects data from database
     * @return String - username
     * @throws SQLException if database isn't found
     */
    String getDB() throws SQLException{
        String name="";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM user WHERE email='"+LoginPageController.email_txt+"'";
                ResultSet result=statement.executeQuery(sql);
                while(result.next()){
                        name = result.getString("name");                   
                }     
            }
        return name;
    } 
}
