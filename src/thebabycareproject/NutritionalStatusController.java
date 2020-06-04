package thebabycareproject;
import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * Controller of the section ' Nutriment ' of the ' Food &amp; Nutrition ' category.
 * Provides nutritional status, daily calorie needs and protein needs for 0-71 months kids.
 * Gender and age are pre-selected from the user's input of child's birthday and gender in database, but it can be 
 * changed.
 * A dialog boxes is added in the top left corner to know more about Weight. 
 * A dialog boxes is added in the top left corner to change nutritious status in database.
 * Status icon and nutritious status label text color is changed according to the calculated nutritious status.
 * @author 2018331059(Sabiha)(BMI-for-age and protien calculation).
 * @author 2018331022(Owishi)(Weight-for-length and calorie according to age and nutritional status calculation).
 */

public class NutritionalStatusController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    ImageIcon im = new ImageIcon(60.0,60.0,"src/image/");
    static String gender="",birthdate="",month="",age="",s="";
    ObservableList<String>  ageList2 = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11");
    ObservableList<String>  ageList1 = FXCollections.observableArrayList("0","1","2","3","4","5");
    ObservableList<String>  genderList = FXCollections.observableArrayList("Boy","Girl");
    ObservableList<String>  weightList = FXCollections.observableArrayList("kg","lbs");
    ObservableList<String>  heightList = FXCollections.observableArrayList("inch","meter","cm");
    ObservableList<String>  activityList = FXCollections.observableArrayList("Bed rest","Very sedentary","Light activity","Moderate activity","Heavy activity","Vigorous activity");
    
    CalorieProtien cp = new CalorieProtien();
    static double heightValue,weightValue,pa;
    
    @FXML ChoiceBox ageChoiceBox1,ageChoiceBox2,genderChoiceBox,weightChoiceBox,heightChoiceBox,activityChoiceBox;
    @FXML TextField height,weight;
    @FXML Label bmilevel,calorie,protien;
    @FXML ImageView imageView;
    @FXML StackPane stackPane;
    @FXML HBox hbox;
    
    /**
     * Provides informations about weight status
     * @param event ActionEvent
     */
    @FXML
    void clickHere(ActionEvent event){
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Ok, I got it!");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            
            dialog.close();
        });
        dialogLayout.setBody(new Text("Nutritious Status or Weight Status:\n\n"+
"0-23 months: A weight-for-length/height z-score (WHZ)is used\n" +
"which compares a child’s weight to the weight of a child of the\n" +
"same length or height and sex to classify nutritional status.\n" +
"Measure children 0–23 months of age or less than 87 cm long\n" +
"lying down (length). Measure children 24–59 months of age or\n" +
"taller than 87 cm standing up (height). \n"+
"2 to 6 years old: We have used BMI-for-age.\n"+
"BMI-for-age percentile shows how your child's weight compares\n" +
"to that of other children of the same age and sex.\n" +
"Please keep in mind that this BMI calculator is not meant to\n" +
"serve as a source of clinical guidance and is not intended to\n" +
"be a substitute for professional medical advice. Because BMI\n" +
"is based on weight and height, it is only an indicator of body\n" +
"fatness. Individuals with the same BMI may have different\n" +
"amounts of body fat. Persons may consider seeking advice from\n" +
"their healthcare providers on healthy weight status."));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        dialogLayout.setActions(ok);
        dialog.show();
        hbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        hbox.setEffect(null);
        });
    }
    
    /**
     * Changes weight status of the user 
     * @param event ActionEvent
     */
    @FXML
    void changeWeightStatus(ActionEvent event){
        if("".equals(s)){
            bmilevel.setText("Please calculate first.");
            bmilevel.setStyle("-fx-text-fill: red;");
        }
        else{
            BoxBlur boxblur = new BoxBlur(3,3,3);
            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            JFXButton change = new JFXButton("Change");
            JFXButton cancel = new JFXButton("Cancel");
            JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
            change.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
                try {
                    changeDB();
                } catch (SQLException ex) {
                    Logger.getLogger(NutritionalStatusController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    gl.loadUI(event, "getbmi");
                } catch (IOException ex) {
                    Logger.getLogger(PlaylistFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
                try {
                    gl.loadUI(event, "getbmi");
                } catch (IOException ex) {
                    Logger.getLogger(NutritionalStatusController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            dialogLayout.setBody(new Text("Your child's diet plan will be changed\n"+
                                    "according to the status. Age will remain same."));
            dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
            change.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
            cancel.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18px;");
            dialogLayout.setActions(change,cancel);
            dialog.show();
            hbox.setEffect(boxblur);
            dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
                hbox.setEffect(null);
            });
        }
    }
    
    /**
     * Calculates weight status, daily calorie and protien need
     * @param event ActionEvent
     */
    @FXML
    void calculate(ActionEvent event){
        if(weight.getText().isEmpty() || height.getText().isEmpty())bmilevel.setText("Please fill up height and weight fields");
        else if(Integer.valueOf((String)ageChoiceBox1.getValue())>2 && activityChoiceBox.getSelectionModel().isEmpty()){
            bmilevel.setStyle("-fx-text-fill: red;");
            imageView.setImage(null);
            bmilevel.setText("Child aged 3 years or more must fill up the PAL box");
            calorie.setText("");
            protien.setText("");
        }
        else 
        {
            if(weightChoiceBox.getValue()=="lbs")weightValue=Double.parseDouble(weight.getText())*0.453592;
            else weightValue=Double.parseDouble(weight.getText());
            if(heightChoiceBox.getValue()=="inch")heightValue=Double.parseDouble(height.getText())*0.0254;
            else if(heightChoiceBox.getValue()=="cm")heightValue=Double.parseDouble(height.getText())*0.01;
            else heightValue=Double.parseDouble(height.getText());
            if("0".equals((String) ageChoiceBox1.getValue()) || "1".equals((String) ageChoiceBox1.getValue())){
                if( heightValue<.45 || heightValue>1)bmilevel.setText("Height for under 2 years must be between 45cm and 100cm to\n know weight status");
                else{
                    CalculateUnder2 getBMI = new CalculateUnder2();
                    int heightInt=(int) (heightValue*100.0);
                    if(genderChoiceBox.getValue()=="Boy")s=getBMI.calculateBoyUnder2(heightInt , weightValue);
                    else s=getBMI.calculateGirlUnder2(heightInt , weightValue);
                    System.out.println(heightValue);
                    System.out.println(weightValue);
                    System.out.println(heightInt);
                    bmilevel.setText(s);
                    if("Underweight".equals(s) || "Overweight".equals(s) || "Obese Catagory".equals(s)){
                        im.setImage("sad", imageView);
                        bmilevel.setStyle("-fx-text-fill: red;");
                    } 
                    else {
                        im.setImage("014-baby-1", imageView);
                        bmilevel.setStyle("-fx-text-fill: #42070b;");
                    }
                }
            }
            else {
                Double bmiValue = (weightValue/((heightValue)*(heightValue)));
                System.out.println(bmiValue);
                CalculatorBMI getBMI = new CalculatorBMI();
                if(genderChoiceBox.getValue()=="Boy")s = getBMI.calculateBoy(bmiValue, Integer.parseInt((String) ageChoiceBox1.getValue()), Integer.parseInt((String) ageChoiceBox2.getValue()));
                else s=getBMI.calculateGirl(bmiValue, Integer.parseInt((String) ageChoiceBox1.getValue()), Integer.parseInt((String) ageChoiceBox2.getValue())); 
                switch (s) {
                    case "u":
                        im.setImage("sad", imageView);
                        bmilevel.setStyle("-fx-text-fill: red;");
                        bmilevel.setText("Underweight");
                        break;
                    case "h":
                        im.setImage("014-baby-1", imageView);
                        bmilevel.setStyle("-fx-text-fill: #42070b;");
                        bmilevel.setText("Healthy");
                        break;
                    case "o":
                        im.setImage("sad", imageView);
                        bmilevel.setStyle("-fx-text-fill: red;");
                        bmilevel.setText("At risk of overweight");
                        break;
                    default:
                        im.setImage("sad", imageView);
                        bmilevel.setStyle("-fx-text-fill: red;");
                        bmilevel.setText("Overweight");
                        break;
                }
            }
       }
       double ppaa=0;
        if(activityChoiceBox.getValue()=="Bed rest")ppaa=1.2;
        else if(activityChoiceBox.getValue()=="Very sedentary")ppaa=1.4;
        else if(activityChoiceBox.getValue()=="Light activity")ppaa=1.6;
        else if(activityChoiceBox.getValue()=="Moderate activity")ppaa=1.8;
        else if(activityChoiceBox.getValue()=="Heavy activity")ppaa=2.0;
        else if(activityChoiceBox.getValue()=="Vigorous activity")ppaa=2.2;
        double result = calpro((String)genderChoiceBox.getValue(),ppaa);
        if(Integer.valueOf((String)ageChoiceBox1.getValue())>2 && activityChoiceBox.getSelectionModel().isEmpty()){}
        else {
            calorie.setText("Calculated energy requirement of your child is " + String.format("%.2f", result) + " kcal/day.");
            result = cp.protien(weightValue);
            protien.setText("Calculated protein requirement of your child is " + String.format("%.2f", result) + " g/day.");
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s="";
        try {
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
            weightChoiceBox.setItems(weightList);
            weightChoiceBox.setValue("kg");
            heightChoiceBox.setItems(heightList);
            heightChoiceBox.setValue("meter");
            activityChoiceBox.setItems(activityList);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(NutritionalStatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**
     * Calculates energy requirement if child is more than 2 years old
     * @param gender String
     * @param pa physical activities point
     * @return double
     */
    double calpro(String gender,double pa){
        double age2 = Double.valueOf((String)ageChoiceBox1.getValue())+Double.valueOf((String)ageChoiceBox2.getValue())/12.0;
        if(ageChoiceBox1.getValue()=="0"){
            if(Integer.valueOf((String)ageChoiceBox2.getValue())<4){
                return cp.zeroToThree(weightValue);
            }
            if(Integer.valueOf((String)ageChoiceBox2.getValue())<7) {
                return cp.fourToSix(weightValue);
            }
            return cp.sevenToTwelve(weightValue);
        }
        if(ageChoiceBox1.getValue()=="1"){
            if(Integer.valueOf((String)ageChoiceBox2.getValue())==0){
                return cp.sevenToTwelve(weightValue);
            }
            return cp.thirteenToThirtySix(weightValue);
        }
        if(ageChoiceBox1.getValue()=="2")return cp.thirteenToThirtySix(weightValue);
        return cp.up(weightValue, gender, age2, pa, heightValue);
    }
    
    /**
     * Collects data from database
     * @throws SQLException if the user database isn't found or connected
     */
    void getDB() throws SQLException{
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
    }
    
    /**
     * Updates nutritional status of user in database
     * @throws SQLException if the user database can't be connected or found
     */
    void changeDB() throws SQLException{
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "")) //address userid password
            {
                System.out.println("Connected");
                String sqlPlaylist = "update user set status=? where email=?";
                try (PreparedStatement statement = connection.prepareStatement(sqlPlaylist)) {
                    statement.setString(1,s);
                    statement.setString(2,LoginPageController.email_txt);
                    statement.executeUpdate();
                    System.out.println("Done changing status");
                    
                }
            }
            System.out.println("Done");
    } 
}
