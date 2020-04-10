/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebabycareproject;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.TrayNotification;
public class ProfileController implements Initializable {
    @FXML 
    TextField name;
    @FXML 
    PasswordField password,re_password;
    @FXML
    DatePicker birthday;
    @FXML 
    CheckBox showPass;
    @FXML
    Label profile_label;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    @FXML
    private void save(ActionEvent event) throws IOException, Exception {
        LocalDate localBirthday = birthday.getValue();
        Validation valid = new Validation();
            if(name.getText().isEmpty() || birthday.getValue()==null || password.getText().isEmpty())profile_label.setText("Please fill the fields");
            if(!valid.validateName(name))profile_label.setText("Username must contain 6 or more characters");
            else if(!valid.validateDate(localBirthday))profile_label.setText("Please pick date correctly");
            else if(!valid.validatePassword(password))profile_label.setText("Password must contain 6 or more letters");
            else if(!password.getText().equals(re_password.getText()))profile_label.setText("The password fields don't match");
            else if(valid.validateDate(localBirthday) && valid.validatePassword(password) && valid.validateName(name) && password.getText().equals(re_password.getText())){
            insertDB();
                Parent pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
                Scene home_page = new Scene(pane);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(home_page);
                stage.show();
                String title = "Congratulations";
                String message = "You've  successfully created your account";       
                Image icon = new Image("/image/icon.png");
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setImage(icon);
                tray.setRectangleFill(Paint.valueOf("#42070B"));
                tray.setMessage(message);
                tray.showAndDismiss(Duration.seconds(2));
         }
    }
    public void insertDB(){
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
            ) {
                System.out.println("Connected");
                String birthdaysql= birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String passwordsql=password.getText();
                String namesql=name.getText();
                String sql = "insert into User (email,birthday,password,name) values(?,?,?,?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1,LoginPageController.email_txt);System.out.println("Done inserting email");
                    statement.setString(2,birthdaysql);System.out.println("Done inserting birthday");
                    statement.setString(3,passwordsql);System.out.println("Done inserting password");
                    statement.setString(4,namesql);System.out.println("Done inserting username");
                    statement.executeUpdate();
                }
            }
            System.out.println("Done");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
}
