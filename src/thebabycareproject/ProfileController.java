package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controller of ' profile '
 * Collects data from new user or changes data of user(password can't be changed).
 * User's information is saved in the local database. 
 * For ' Profile Settings ' pre-written data is collected from the database, change is applicable only when user 
 * provide correct password.
 * A dialog box is added for further needed information of a certain field.
 * Provided birthday can't be the running or upcoming day.
 * @author 2018331022(Owishi)
 */

public class ProfileController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML StackPane stackPane;
    @FXML VBox vbox;
    @FXML TextField name;
    @FXML PasswordField password,re_password;
    @FXML DatePicker birthday;
    @FXML CheckBox showPass;
    @FXML Label profile_label;
    @FXML ChoiceBox genderChoiceBox,statusChoiceBox; 
    ObservableList<String>  genderList = FXCollections.observableArrayList("Boy","Girl");
    ObservableList<String>  statusList = FXCollections.observableArrayList("Underweight","Healthy","At risk of overweight","Overweight","Obese Catagory");
    String birthdaysql,namesql,passwordsql;
    
    /**
     * Creates new account or changes info about the user
     * @param event ActionEvent
     * @throws Exception if password or user's info isn't found 
     */
    @FXML
    private void save(ActionEvent event) throws Exception {
        LocalDate localBirthday = birthday.getValue();
        Validation valid = new Validation();
            if(name.getText().isEmpty() || birthday.getValue()==null || password.getText().isEmpty() || re_password.getText().isEmpty())profile_label.setText("Please fill the fields");
            else if(!valid.validateName(name))profile_label.setText("Username must contain 6 or more characters");
            else if(!valid.validateDate(localBirthday))profile_label.setText("Please pick date correctly");
            else if(!valid.validatePassword(password))profile_label.setText("Password must contain 6 or more letters");
            else if(!password.getText().equals(re_password.getText()))profile_label.setText("The password fields don't match");
            else if(valid.validateDate(localBirthday) && valid.validatePassword(password) && valid.validateName(name) && password.getText().equals(re_password.getText())){
                birthdaysql= birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                passwordsql=password.getText();
                namesql=name.getText();
                if(checkDB_without_pass(LoginPageController.email_txt) && !check_pass(passwordsql))profile_label.setText("Type your password correctly");
                else if(checkDB_without_pass(LoginPageController.email_txt) && check_pass(passwordsql)){
                    changeDB();
                    gl.notification("Hey!", "You've successfully changed your informations");
                }
                else {
                    insertDB();    
                    gl.setMusic();
                    gl.notification("Congratulations", "You've successfully created your account");      
                } 
                gl.loadUI(event, "homePage");
            }
            else{
                
            }
    }
    
    /**
     * Provides information about weight status
     * @param event MouseEvent
     */
    @FXML
    void questionMark(MouseEvent event){
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Ok, I got it!");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            
            dialog.close();
        });
        dialogLayout.setBody(new Text(
                "If you don't know about weight status,go to Food & nutrition\n"+
                "and calculate. For now you can save 'Healthy' as a default.\n"+
                "You may change it later. It is necessary for diet plan."));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        dialogLayout.setActions(ok);
        dialog.show();
        vbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        vbox.setEffect(null);
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            genderChoiceBox.setItems(genderList);
            statusChoiceBox.setItems(statusList);
            if(checkDB_without_pass(LoginPageController.email_txt))try {
                getDB();
            } catch (SQLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
            else {
                genderChoiceBox.setValue("Boy");
                statusChoiceBox.setValue("Healthy");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Insert new user's data to user database
     * @throws SQLException if the user database can't be found or connected
     */
    void insertDB() throws SQLException{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
            ) {
                System.out.println("Connected");
                String sql = "insert into user (email,birthday,password,name,gender,status) values(?,?,?,?,?,?)";
                String sqlPlaylist = "insert into playlist (email,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1,LoginPageController.email_txt);System.out.println("Done inserting email");
                    statement.setString(2,birthdaysql);System.out.println("Done inserting birthday");
                    statement.setString(3,passwordsql);System.out.println("Done inserting password");
                    statement.setString(4,namesql);System.out.println("Done inserting username");
                    statement.setString(5,genderChoiceBox.getValue().toString());System.out.println("Done inserting gender");
                    statement.setString(6,statusChoiceBox.getValue().toString());System.out.println("Done inserting status");
                    statement.executeUpdate();
                    System.out.println("okay");
                }
                try (PreparedStatement statement = connection.prepareStatement(sqlPlaylist)) {
                    statement.setString(1,LoginPageController.email_txt);System.out.println("Done inserting email in playlist");
                    for(int i=2;i<=11;i++){
                        statement.setString(i,"0");System.out.println("p"+i);
                    }
                    for(int i=12;i<=21;i++){
                        statement.setString(i,"0");System.out.println("s"+i);
                    }
                statement.executeUpdate();
                }
            }
            System.out.println("Done");
    }
    
    /**
     * Checks if the database has any account created by the given email
     * @param email user's email
     * @return boolean if user database has the account
     * @throws SQLException if the user database can't be found or connected
     */
    boolean checkDB_without_pass(String email) throws SQLException{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM User WHERE email='"+email+"'";
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
    
    /**
     * String to local date
     * @param dateString date in String format
     * @return LoacalDate date in LoacalDate format
     */
    static final LocalDate LOCAL_DATE (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
    }
    
    /**
     * Gets the informations of the user
     * @throws SQLException if database can't be connected or operations are incorrect
     */
    void getDB() throws SQLException{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM user WHERE email='"+LoginPageController.email_txt+"'";
                ResultSet result=statement.executeQuery(sql);
                while(result.next()){
                        name.setText(result.getString("name"));
                        genderChoiceBox.setValue(result.getString("gender"));
                        birthday.setValue(LOCAL_DATE(result.getString("birthday")));
                        statusChoiceBox.setValue(result.getString("status"));               
                }     
            }
    }
    
    /**
     * Check the password of the user
     * @param password user's input password
     * @return boolean if the given password in password field matches with the password of user database
     * @throws SQLException if database can't be connected or the operations are incorrect
     */
    boolean check_pass(String password) throws SQLException{
        String getPass = null;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM user WHERE email='"+LoginPageController.email_txt+"'";
                ResultSet result=statement.executeQuery(sql);
                while(result.next()){
                       getPass = result.getString("password");            
                }
            }
        return getPass.equals(password);
    }

    /**
     * Changes certain information of the user
     * @throws SQLException if the user database can't be found or connected 
     */
    void changeDB() throws SQLException{
        ProfileController pc = new ProfileController();
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
            ){
                namesql=name.getText();
                birthdaysql= birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println(birthdaysql);
                //System.out.println("Connected");
                String sqlPlaylist = "update user set name=?,gender=?,birthday=?,status=? where email=?";
                try (PreparedStatement statement = connection.prepareStatement(sqlPlaylist)) {
                    statement.setString(1,namesql);
                    statement.setString(2,genderChoiceBox.getValue().toString());
                    statement.setString(3,birthdaysql);
                    statement.setString(4,statusChoiceBox.getValue().toString());
                    statement.setString(5,LoginPageController.email_txt);
                    statement.executeUpdate();
                    System.out.println("Done changing status");   
                }
            }
            System.out.println("Done");
    }
}
