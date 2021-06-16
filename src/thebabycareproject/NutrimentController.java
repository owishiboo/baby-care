package thebabycareproject;
import com.jfoenix.controls.JFXButton;
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
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

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
    ObservableList<String>  ageList2 = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11");
    ObservableList<String>  ageList1 = FXCollections.observableArrayList("0","1","2","3","4","5");
    ObservableList<String>  statusList = FXCollections.observableArrayList("Underweight","Healthy","At risk of overweight","Overweight","Obese Catagory");
    static String s1,s2,s3,birthdate,status;
    static String type, weightType="o", weekType="",callType="";
    static private String gotStatus="",gotAge="",gotMonth="";
    static Boolean shift=false;
    ImageIcon ic = new ImageIcon(90, 90, "src/diet");
    GoAndLoad gl = new GoAndLoad();
    @FXML JFXButton button1,button2,button3,button4,button5;
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
    void button1(ActionEvent event) throws IOException{
        callType="daily";
        gl.loadUI(event, "dietChart");
    }
    @FXML
    void button2(ActionEvent event) throws IOException{
        callType="WeeklyDietChart";
        gl.loadUI(event, "dietChart");
    }
    @FXML
    void button3(ActionEvent event) throws IOException{
        if(type.equals("25-36/") || type.equals("37-72/"))callType="leftovers";
        else callType="specialCare";
        gl.loadUI(event, "dietChart");
    }
    @FXML
    void button4(ActionEvent event) throws IOException{
        callType="restrictions";
        gl.loadUI(event, "dietChart");
    }
    @FXML
    void button5(ActionEvent event) throws IOException{
        todo();
        callType=weightType;
        gl.loadUI(event, "dietChart");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getDB();
            LocalDate today = LocalDate.now();
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
            LocalDate birthdate1 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(birthdate1, today);
            ageChoiceBox1.setItems(ageList1);
            ageChoiceBox2.setItems(ageList2);
            statusChoiceBox.setItems(statusList);
            if(!shift){
                ageChoiceBox1.setValue(Integer.toString(period.getYears()));
                ageChoiceBox2.setValue(Integer.toString(period.getMonths()));
                statusChoiceBox.setValue(status);
                System.out.println("HERE");
            }
            else {
                ageChoiceBox1.setValue(gotAge);
                ageChoiceBox2.setValue(gotMonth);
                statusChoiceBox.setValue(gotStatus);
            }
            
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
        gotAge =  s1;
        gotMonth = s2;
        gotStatus = s3;
        System.out.println(gotAge);
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        switch (s1) {
            case "0":
                if(Integer.valueOf(s2)<=3){type="0-3/";button2.setDisable(true);}
                else if(Integer.valueOf(s2)<=6)type="4-6/";
                else if(Integer.valueOf(s2)<=9)type="7-9/";
                else type="10-12/";
                break;
            case "1":
                if(Integer.valueOf(s2)==0)type="10-12/";
                else if(Integer.valueOf(s2)<=6)type="13-18/";
                else type="19-24/";
                break;
            case "2":
                if(Integer.valueOf(s2)==0)type="19-24/";
                else {type="25-36/";button4.setDisable(true);button2.setDisable(true);}
                break;
            default:
                type="37-72/";
                button4.setDisable(true);
                button2.setDisable(true);
                break;
        }
        switch (s3) {
            case "Underweight":
                weightType="u";
                break;
            case "Healthy":
                weightType="h";
                button5.setDisable(true);
                break;
        }
        switch (type) {
            case "4-6/":
                weekType="";
                break;
            case "7-9/":
                if(null==Integer.valueOf(s2))weekType="9";
                else if(Integer.parseInt(s2)==0)weekType="9";
                else switch (Integer.valueOf(s2)) {
                case 7:
                    weekType="7";
                    break;
                case 8:
                    weekType="8";
                    break;
                default:
                    weekType="9";
                    break;
                }
                break;
            case "10-12/":
                if(null==Integer.valueOf(s2))weekType="12";
                else if(Integer.parseInt(s2)==0)weekType="12";
                else switch (Integer.valueOf(s2)) {
                case 10:
                    weekType="10";
                    break;
                case 11:
                    weekType="11";
                    break;
                default:
                    weekType="12";
                    break;
                }
                break;
            case "13-18/":
                weekType="";
                break;
            case "19-24/":
                weekType="";
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

