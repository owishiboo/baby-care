package thebabycareproject;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class GetbmiController {
    @FXML
    private Label label;
    @FXML
    private Button buttonCalculate;
    @FXML
    private TextField bmiOutput;
    @FXML
    private TextField statusOutput;
    @FXML
    private TextField weightInput;
    @FXML
    public Label Suggestion;
    @FXML
    private TextField heightInput;    
    @FXML
    private TextField ageInput;
    @FXML
    private TextField genInput;
    @FXML
    private Button suggestionOutput;
    @FXML
    void calculate(ActionEvent event) {
        try{
            Double weightValue = Double.parseDouble(weightInput.getText());
            Double heightValue = Double.parseDouble(heightInput.getText());
            Double bmiValue = (weightValue/((heightValue/100)*(heightValue/100)));
            setResult(bmiValue);
            if("Underweight".equals(statusOutput.getText()))Suggestion.setText("Get a balanced and nutritious diet for him.\nYou may consult a doctor to get a perfect diet for your child.\nTake care!");
            if("Normal Weight".equals(statusOutput.getText()))Suggestion.setText("Your child is perfect! Keep it up!");
            else if("Obesity".equals(statusOutput.getText()))Suggestion.setText("Get a balanced diet for him.\nChildren can get some physical activities too if\n it is needed.You may consult a doctor to get a \nperfect diet for your child.\nTake care!");
            else Suggestion.setText("");
        }
        
        catch(Exception e){  
        }
    }
    void setResult(Double bmiValue)
    {
        //bmiOutput.setText(bmiValue.toString());
        Integer ageVal = Integer.parseInt(ageInput.getText());
        String  gender = genInput.getText();
        if(gender == "Girl")
        {
            if(ageVal>=24 &&  ageVal<=27 && bmiValue<=13.7)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        else if( ageVal>27  && ageVal<=31 && bmiValue<=13.6)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        else if( ageVal>31  && ageVal<=36 && bmiValue<=13.5)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
         else if( ageVal>32  && ageVal<=40 && bmiValue<=13.4)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        
          else if( ageVal>40  && ageVal<=45 && bmiValue<=13.3)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        
          else if( ageVal>45  && ageVal<=51 && bmiValue<=13.2)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
          else if( ageVal>51  && ageVal<=60 && bmiValue<=13.1)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        else if( (ageVal==24) && (bmiValue>13.7 &&  bmiValue<=17.2))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
         else if( (ageVal>24 &&  ageVal<=27) && (bmiValue>13.7 &&  bmiValue<=17.1))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>27 &&  ageVal<=31) && (bmiValue>13.6 &&  bmiValue<=17.0))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>31 &&  ageVal<=36) && (bmiValue>13.5 &&  bmiValue<=16.9))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>36 &&  ageVal<=51) && (bmiValue>13.1 &&  bmiValue<=16.8))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>51 &&  ageVal<=60) && (bmiValue>13.0 &&  bmiValue<=16.9))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
        else
          {
           bmiOutput.setText("95th Percentile");
           statusOutput.setText("Obesity"); 
          }
        
        }
        
        else
        {
            if(ageVal==24 && bmiValue<=14.2)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        else if( ageVal>24  && ageVal<=26 && bmiValue<=14.1)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        else if( ageVal>26  && ageVal<=29 && bmiValue<=14.0)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
         else if( ageVal>29  && ageVal<=32 && bmiValue<=13.9)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        
          else if( ageVal>32  && ageVal<=35 && bmiValue<=13.8)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        
          else if( ageVal>35  && ageVal<=38 && bmiValue<=13.7)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
          else if( ageVal>38  && ageVal<=42 && bmiValue<=13.6)
        { bmiOutput.setText("5th Percentile");
          statusOutput.setText("Underweight");
        }
        else if( (ageVal>42 && ageVal<=47   &&  bmiValue<=13.5))
        {  bmiOutput.setText("5th Percentile");
          statusOutput.setText("UnderWeight");
        }
        else if( (ageVal>47 && ageVal<=52   &&  bmiValue<=13.4))
        {  bmiOutput.setText("5th Percentile");
          statusOutput.setText("UnderWeight");
        }
        else if( (ageVal>52 && ageVal<=60   &&  bmiValue<=13.3))
        {  bmiOutput.setText("5th Percentile");
          statusOutput.setText("UnderWeight");
        }
         else if( (ageVal>=24 &&  ageVal<=25) && (bmiValue>14.1 &&  bmiValue<=17.4))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>25 &&  ageVal<=27) && (bmiValue>14.0 &&  bmiValue<=17.3))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>27 &&  ageVal<=30) && (bmiValue>13.9 &&  bmiValue<=17.2))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>30 &&  ageVal<=32) && (bmiValue>13.8 &&  bmiValue<=17.1))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
          else if( (ageVal>32 &&  ageVal<=36) && (bmiValue>13.7 &&  bmiValue<=17.0))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
           else if( (ageVal>36 &&  ageVal<=39) && (bmiValue>13.6 &&  bmiValue<=16.9))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
           else if( (ageVal>39 &&  ageVal<=45) && (bmiValue>13.5 &&  bmiValue<=16.8))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
           else if( (ageVal>45 &&  ageVal<=60) && (bmiValue>13.0 &&  bmiValue<=16.7))
        { bmiOutput.setText("85th Percentile");
          statusOutput.setText("Normal Weight");
        }
           
        else
          {
           bmiOutput.setText("95th Percentile");
           statusOutput.setText("Obesity"); 
          }
        
        }
    }  
    @FXML
    public void goBack(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show();      
    }
}