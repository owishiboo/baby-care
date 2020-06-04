package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static thebabycareproject.NutrimentController.*;

/**
 * Controller of the sub-section ' Diet Chart ' of section 'Nutriment' of the ' Food &amp; Nutrition ' category.
 * Loads weekly diet plan according to child's age and weight status.
 * Loads icons according to child's age.
 * Diet plan are saved as png images, created in PowerPoint.
 * @author 2018331022(Owishi) created diet chart for above 12 months.
 * @author 2018331022(Sabiha) created diet chart for 4-12 months.
 */
public class DietChartController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    ImageIcon im = new ImageIcon(392.5, 785, "src/diet");
    ImageIcon ic = new ImageIcon(90, 90, "src/diet");
    @FXML ImageView daily,weekly,status,babyIcon;
    @FXML Label dietPlanLabel,bmfmLabel;
    
    /**
     * Loads ' Nutritional Status ' in the center of BorderPane
     * @param event MouseEvent on ImageView
     * @throws IOException if the fxml isn't found
     */
    @FXML
     void goBack(MouseEvent event) throws IOException{
        gl.loadUI(event, "getbmi");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dietPlanLabel.setStyle("-fx-font-weight: bold;");
        if("0".equals(s1)){
            if(Integer.valueOf(s2)<=3){
                dietPlanLabel.setText("Daily diet plan for 0-3 months old infant");
                //bmfmLabel.setText("**BM = Breast Milk, FM = formula Milk");
                //setImage("0-3/all",weekly);//0-3 er jonne kono weekly routine nai
                im.setImage("0-3/daily",daily);
                ic.setImage("0-3/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("0-3/u",status);
                        
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("0-3/o",status);
                        break;
                }
            }
            else if(Integer.valueOf(s2)<=6){
                dietPlanLabel.setText("Weekly diet plan for 4-6 months old infant");
                bmfmLabel.setText("**BM = Breast Milk, FM = formula Milk");
                im.setImage("4-6/weekly",weekly);//0-3 er jonne kono weekly routine nai
                im.setImage("4-6/daily",daily);
                ic.setImage("4-6/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("4-6/u",status);
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("4-6/o",status);
                        break;
                }
            }
            else if(Integer.valueOf(s2)<=9){
                dietPlanLabel.setText("Weekly diet plan for 7-9 months old infant");
                bmfmLabel.setText("**BM = Breast Milk, FM = formula Milk");
                if(Integer.valueOf(s2)==7)im.setImage("7-9/weekly7",weekly);
                else if(Integer.valueOf(s2)==8)im.setImage("7-9/weekly8",weekly);
                if(Integer.valueOf(s2)==9)im.setImage("7-9/weekly9",weekly);
                im.setImage("7-9/daily",daily);
                ic.setImage("7-9/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("7-9/u",status);
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("7-9/o",status);
                        break;
                }
            }
            else{
                dietPlanLabel.setText("Weekly diet plan for 10-12 months old infant");
                bmfmLabel.setText("**BM = Breast Milk, FM = formula Milk");
                if(Integer.valueOf(s2)==10)im.setImage("10-12/weekly10",weekly);
                else if(Integer.valueOf(s2)==11)im.setImage("10-12/weekly11",weekly);
                if(Integer.valueOf(s2)==12)im.setImage("10-12/weekly12",weekly);
                im.setImage("10-12/daily",daily);
                ic.setImage("10-12/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("10-12/u",status);
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("10-12/o",status);
                        break;
                }
            }
            
        }
        if("1".equals(s1)){
            if(Integer.valueOf(s2)==0){
                dietPlanLabel.setText("Weekly diet plan for 10-12 months old infant");
                bmfmLabel.setText("**BM = Breast Milk, FM = formula Milk");
                if(Integer.valueOf(s2)==10)im.setImage("10-12/weekly10",weekly);
                else if(Integer.valueOf(s2)==11)im.setImage("10-12/weekly11",weekly);
                if(Integer.valueOf(s2)==12)im.setImage("10-12/weekly12",weekly);
                im.setImage("10-12/daily",daily);
                ic.setImage("10-12/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("10-12/u",status);
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("10-12/o",status);
                        break;
                }
            }
            else if(Integer.valueOf(s2)<=6){
                dietPlanLabel.setText("Weekly diet plan for 13-18 months old child");
                bmfmLabel.setText("At this time breastfeeding varies from child to child. So make a chart of feeding according to your convenience and your child’s nursing.");
                im.setImage("13-18/weekly",weekly);
                im.setImage("13-18/daily",daily);
                ic.setImage("13-18/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("13-18/u",status);
                        
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("13-18/o",status);
                        break;
                }
            }
            else {
                dietPlanLabel.setText("Weekly diet plan for 19-24 months old child");
                bmfmLabel.setText("At this time breastfeeding varies from child to child. So make a chart of feeding according to your convenience and your child’s nursing.");
                im.setImage("13-18/weekly",weekly);
                im.setImage("13-18/daily",daily);
                ic.setImage("13-18/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("13-18/u",status);
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("13-18/o",status);
                        break;
                }
            }
        }
        if("2".equals(s1)){
            if(Integer.valueOf(s2)==0){
                dietPlanLabel.setText("Weekly diet plan for 19-24 months old child");
                bmfmLabel.setText("At this time breastfeeding varies from child to child. So make a chart of feeding according to your convenience\n and your child’s nursing.");
                im.setImage("19-24/weekly",weekly);
                im.setImage("19-24/daily",daily);
                ic.setImage("19-24/baby",babyIcon);
            }
            else{
                dietPlanLabel.setText("Daily diet plan for 25-36 months old child");
                bmfmLabel.setText("");
                im.setImage("25-36/daily",daily);
                ic.setImage("25-36/baby",babyIcon);
                switch (s3) {
                    case "Underweight":
                        im.setImage("25-36/u",status);
                        
                        break;
                    case "Healthy":
                        break;
                    default:
                        im.setImage("25-36/o",status);
                        break;
                }
            }
        }
        if(Integer.valueOf(s1)>=3) {
            dietPlanLabel.setText("Daily diet plan for 37-72 months old child");
            bmfmLabel.setText("");
            im.setImage("37-72/daily",daily);
            ic.setImage("37-72/baby",babyIcon);
            switch (s3) {
                case "Underweight":
                    im.setImage("37-72/u",status);                      
                    break;
                case "Healthy":
                    break;
                default:
                    im.setImage("37-72/o",status);
                    break;
            }
        }
    }
} 
    

