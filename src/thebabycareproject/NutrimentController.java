package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controller of the section ' Nutriment ' of the ' Food &amp; Nutrition ' category.
 * Has a subsection named ' Diet Chart '.
 * Contains restrictions and special care(if needed) about feeding child according to the child's age and gender.
 * Restrictions and special care are loaded as images according to age and gender, images are created in PowerPoint.
 * There is a titled pane on top to change the diet chart, restrictions and special care according to age, gender 
 * and nutritious status(or weight status).
 * Gender and age in the titled pane are pre-selected from the user's input of child's birthday and gender in
 * database, but it can be changed.
 * @author 2018331022(Owishi)
 */

public class NutrimentController implements Initializable {
    ImageIcon im = new ImageIcon(310,615,"src/diet");
    @FXML ChoiceBox ageChoiceBox1,ageChoiceBox2,statusChoiceBox;
    @FXML ImageView specialCare,restrictions;
    ObservableList<String>  ageList2 = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11");
    ObservableList<String>  ageList1 = FXCollections.observableArrayList("0","1","2","3","4","5");
    ObservableList<String>  statusList = FXCollections.observableArrayList("Underweight","Healthy","At risk of overweight","Overweight","Obese Catagory");
    static String s1,s2,s3,birthdate,status;
    
    /**
     * Calls a method to change diet plan 
     * @param event ActionEvent
     */
    @FXML
    void changeDietPlan(ActionEvent event){
        todo();        
    }
    
    /**
     * Loads dietChart fxml
     * @param event ActionEvent
     * @throws IOException if the fxml isn't found
     */

    @FXML
    void dietChart(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("dietChart.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getDB();
            LocalDate today = LocalDate.now();
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
            LocalDate birthdate1 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(birthdate1, today);
            String ss;
            switch (status) {
                case "u":
                    ss = "Underweight";
                    break;
                case "o":
                    ss = "At risk of overweight";
                    break;
                case "h":
                    ss = "Healthy";
                    break;
                case "n":
                    ss = "Overweight";
                    break;
                default:
                    ss = status;
                    break;
            }
            ageChoiceBox1.setItems(ageList1);
            ageChoiceBox1.setValue(Integer.toString(period.getYears()));
            ageChoiceBox2.setItems(ageList2);
            ageChoiceBox2.setValue(Integer.toString(period.getMonths()));
            statusChoiceBox.setItems(statusList);
            statusChoiceBox.setValue(ss);
            todo();
            
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(NutrimentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Changes diet chart, restrictions and special care according to the given values
     */
    void todo(){
        s1=(String) ageChoiceBox1.getValue();//year
        s2=(String) ageChoiceBox2.getValue();//month
        s3=(String) statusChoiceBox.getValue();
        if(null == s1){
            im.setImage("37-72/leftovers",specialCare);
        }
        else switch (s1) {
            case "0":
                if(Integer.valueOf(s2)<=3){
                    im.setImage("0-3/specialCare",specialCare);
                    im.setImage("0-3/restrictions",restrictions);
                }
                else if(Integer.valueOf(s2)<=6){
                    im.setImage("4-6/specialCare",specialCare);
                    im.setImage("4-6/restrictions",restrictions);
                }
                else if(Integer.valueOf(s2)<=9){
                    im.setImage("7-9/specialCare",specialCare);
                    im.setImage("7-9/restrictions",restrictions);
                }
                else {
                    im.setImage("10-12/specialCare",specialCare);
                    im.setImage("10-12/restrictions",restrictions);
                }   break;
            case "1":
                if(Integer.valueOf(s2)==0){
                    im.setImage("10-12/specialCare",specialCare);
                    im.setImage("10-12/restrictions",restrictions);
                }
                else if(Integer.valueOf(s2)<=6){
                    im.setImage("13-18/specialCare",specialCare);
                    im.setImage("13-18/restrictions",restrictions);
                }
                else {
                    im.setImage("19-24/specialCare",specialCare);
                    im.setImage("19-24/restrictions",restrictions);
                }   break;
            case "2":
                if(Integer.valueOf(s2)==0){
                    im.setImage("19-24/specialCare",specialCare);
                    im.setImage("19-24/restrictions",restrictions);
                }
                else im.setImage("25-36/leftovers",specialCare);
                break;
            default:
                im.setImage("37-72/leftovers",specialCare);
                break;
        }
    }

    /**
     * gets weight status of the user from database
     * @throws SQLException if the user database can't be found or connected
     */
    void getDB() throws SQLException{       
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
        System.out.println("Connected");  
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM user WHERE email='"+LoginPageController.email_txt+"'";
            ResultSet result=statement.executeQuery(sql);
            while(result.next()){
                birthdate = result.getString("birthday");
                status = result.getString("status");
            }     
        }
    }    
    
}

