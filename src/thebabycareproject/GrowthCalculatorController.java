package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.events.JFXDialogEvent;
import com.jfoenix.validation.NumberValidator;
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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.*;
/**
 * Controller of the section ' Growth Calculator ' of the ' Growth &amp; Immunity ' category.
 * Calculates head circumference-for-age(Applicable for 0-36 months) and stature-for-age(Applicable for 24-71 months)
 * according to gender and age. Gender and age are pre-selected from the user's input of child's birthday and 
 * gender in database, but it can be changed.
 * Needs age, height, head circumference and gender to calculate.
 * A dialog box is added in the top left corner to know more about the calculator.
 * @author 2018331022(Owishi)
 */
public class GrowthCalculatorController implements Initializable {
    @FXML ChoiceBox ageChoiceBox1,ageChoiceBox2,genderChoiceBox,heightChoiceBox,circumChoiceBox;
    @FXML JFXTextField height,circum;
    @FXML Label circumLabel;
    @FXML StackPane stackPane;
    @FXML VBox vbox;
    ObservableList<String>  ageList2 = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11");
    ObservableList<String>  ageList1 = FXCollections.observableArrayList("0","1","2","3","4","5");
    ObservableList<String>  genderList = FXCollections.observableArrayList("Boy","Girl");
    ObservableList<String>  heightList = FXCollections.observableArrayList("inch","meter","cm");
    static double heightValue=0.0,circumValue=0.0,ageValue;
    static String gender="",birthdate="",month="";
    String result1="Applicable for 3 Years or Less",result2="Applicable for 2 Years or More";
    
    /**
     * Provides information about growth calculator
     * @param event ActionEvent
     */
    @FXML
    void clickHere(ActionEvent event){
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Okay, I got it!");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            
            dialog.close();
        });
        dialogLayout.setBody(new Text("Here we've used head cicumference-for-age and statute-for-age for\n"
                + "calculation.\n"
                + "Head circumference is a measurement of a child's head around\n"
                + "its largest area. It measures the distance from above the\n"
                + "eyebrows and ears and around the back of the head.\n"
                + "Microcephaly is a condition where the head (circumference)\n"
                + "is smaller than normal. Microcephaly may be caused by\n"
                + "genetic abnormalities or by drugs, alcohol, certain viruses,\n"
                + "and toxins that are exposed to the fetus during pregnancy and\n"
                + "damage the developing brain tissue.\n"
                + "Macrocephaly is the term for an unusually large head. An\n"
                + "infant with macrocephaly have a larger head than most other\n"
                + "infants of the same age and sex. In many cases, this condition\n"
                + "is benign or harmless. In other cases, it may indicate\n"
                + "underlying medical condition, such as a genetic syndrome\n"
                + "a brain tumor.\n"));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        dialogLayout.setActions(ok);
        dialog.show();
        vbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        vbox.setEffect(null);
        });
    }
    
    /**
     * Calculates according to the given informations
     * @param event ActionEvent
     */
    @FXML
    void calculate(ActionEvent event){
        ageValue = Double.valueOf((String) ageChoiceBox1.getValue())*12+Double.valueOf((String) ageChoiceBox2.getValue());
        if(!height.getText().isEmpty()){
                if(heightChoiceBox.getValue()=="inch")heightValue=Double.parseDouble(height.getText())*2.54;
                else if(heightChoiceBox.getValue()=="meter")heightValue=Double.parseDouble(height.getText())*100.0;
                else heightValue=Double.parseDouble(height.getText());
        }
        if(circum.getText().isEmpty())System.out.println("I am empty");
        
        if(!circum.getText().isEmpty()){
                if(circumChoiceBox.getValue()=="inch")circumValue=Double.parseDouble(circum.getText())*2.54;
                else if(circumChoiceBox.getValue()=="meter")circumValue=Double.parseDouble(circum.getText())*100.0;
                else circumValue=Double.parseDouble(circum.getText());
        } 
        if(circum.getText().isEmpty() && height.getText().isEmpty() && ageValue>=24.0 && ageValue<=36.0)
            circumLabel.setText("Please fill up the fields");
        else if(circum.getText().isEmpty() && ageValue<=36.0)
            circumLabel.setText("Please fill up the head circumference field");
        else if(height.getText().isEmpty() && ageValue>=24.0)
            circumLabel.setText("Please fill up the height field");
        else 
        {
            HeadCircum hc = new HeadCircum();
            if(ageValue>=24.0 && ageValue<=36.0){
            result1 = hc.circum((String) genderChoiceBox.getValue(), circumValue, ageValue);
            result2 = hc.stature((String) genderChoiceBox.getValue(), heightValue, ageValue);
            }
            else if(ageValue<=36.0)
                result1 = hc.circum((String) genderChoiceBox.getValue(), circumValue, ageValue);
            
            else
                result2 = hc.stature((String) genderChoiceBox.getValue(), heightValue, ageValue);
            BoxBlur boxblur = new BoxBlur(3,3,3);
            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            JFXButton ok = new JFXButton("Okay");
            JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
            ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            
                dialog.close();
            });
            dialogLayout.setBody(new Text("Head Circumference-for-age: "+result1+"\n"
            +"Calculate Stature-for-age: "+result2));
            dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
            ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
            dialogLayout.setActions(ok);
            dialog.show();
            vbox.setEffect(boxblur);
            dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
            vbox.setEffect(null);
            });
           }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            circumLabel.setStyle("-fx-text-fill: red;");
            getDB();
            LocalDate today = LocalDate.now();
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
            LocalDate birthdate2 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(birthdate2, today);
            System.out.println(period.getYears()+" "+ period.getMonths());
            ageChoiceBox1.setItems(ageList1);
            ageChoiceBox2.setItems(ageList2);
            ageChoiceBox1.setValue(Integer.toString(period.getYears()));
            ageChoiceBox2.setValue(Integer.toString(period.getMonths()));
            genderChoiceBox.setItems(genderList);
            genderChoiceBox.setValue(gender);
            heightChoiceBox.setItems(heightList);
            heightChoiceBox.setValue("meter");
            circumChoiceBox.setItems(heightList);
            circumChoiceBox.setValue("meter");
            NumberValidator numValidator = new NumberValidator();
            numValidator.setMessage("numbers only");
            height.getValidators().add(numValidator);
            circum.getValidators().add(numValidator);
            height.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if(!newValue){
                    if(!height.validate()){
                        height.setText("");
                    }
                }
            });
            circum.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if(!newValue){
                    if(!circum.validate()){
                        circum.setText("");
                    }
                }
            });
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(NutritionalStatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Collects data from database
     * @throws SQLException if the database can't be found or connected
     */
    void getDB() throws SQLException{
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM user WHERE email='"+LoginPageController.email_txt+"'";
                ResultSet result=statement.executeQuery(sql);
                while(result.next()){
                        gender = result.getString("gender");
                        birthdate = result.getString("birthday");
                }     
            }
        }catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }    
    
}