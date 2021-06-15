package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static thebabycareproject.NutrimentController.*;
import static thebabycareproject.GetbmiController.centerOfFoodAndNutrition;

/**
 * Controller of the sub-section ' Diet Chart ' of section 'Nutriment' of the ' Food &amp; Nutrition ' category.
 * Loads chart diet plan according to child's age and weight status.
 Loads icons according to child's age.
 Diet plan are saved as png images, created in PowerPoint.
 * @author 2018331022(Owishi) created diet chart for above 12 months.
 * @author 2018331022(Sabiha) created diet chart for 4-12 months.
 */
public class DietChartController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    ImageIcon im = new ImageIcon(390, 780, "src/diet");
    @FXML ImageView chart;
    @FXML Label bmfmLabel;
    
    /**
     * Loads ' Nutritional Status ' in the centerOfFoodAndNutrition of BorderPane
     * @param event MouseEvent on ImageView
     * @throws IOException if the fxml isn't found
     */
    @FXML
     void goBack(ActionEvent event) throws IOException{
        centerOfFoodAndNutrition = "nutriment";
        gl.loadUI(event, "getbmi");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NutrimentController.shift = true;
        if(callType.equals("WeeklyDietChart"))im.setImage(type+"weekly"+weekType,chart);
        else im.setImage(type+callType,chart);
        if("0".equals(s1) || ("1".equals(s1) && "0".equals(s2)))bmfmLabel.setText("**BM = Breast Milk, FM = formula Milk");
        else bmfmLabel.setText("After a year, breastfeeding varies from child to child. So make a chart of feeding according to your convenience and "
                + "\nyour child’s nursing.");
    }
    
} 
    

