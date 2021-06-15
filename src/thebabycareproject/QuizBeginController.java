package thebabycareproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author 2018331022(owishi)
 */
public class QuizBeginController extends Application implements Initializable {
    
    QuizHandle qz = new QuizHandle(QuizController.type);
    @FXML Label label,labelMin,zeroLabel;
    @FXML Button startStop;
    long min, sec, hr, totalSec = 0; //250 4 min 10 sec
    Timer coutdownTimer;
    @FXML StackPane stackPane;
    @FXML BorderPane borderpane;
    GoAndLoad gl = new GoAndLoad();
    BooleanProperty running = new SimpleBooleanProperty();
    DoubleProperty time = new SimpleDoubleProperty();
    AnimationTimer CountTimer;   
    private static long differ=0;
    private String format(long value) {
        if (value < 10) {
            return 0 + "" + value;
        }

        return value + "";
    }
    @Override
    public void start(Stage primaryStage) {      
        label.textProperty().bind(time.asString("%.0f"));      
        CountTimer = new AnimationTimer() {
            private long startTime,now;
            @Override
            public void start() {
                System.out.println("In start " + differ);
                startTime = System.currentTimeMillis() + QuizBeginController.differ;
                running.set(true);
                super.start();
            }
            @Override
            public void stop() {
                running.set(false);
                startStop.setDisable(true);
                //System.out.println("In stop " + running.getValue());
                super.stop();
                QuizBeginController.differ=0;
                //System.out.println("In stop " + differ);
            }
            @Override
            public void handle(long timestamp) {
                //System.out.println("In handle " + running.getValue());
                now = System.currentTimeMillis();
                if(QuizController.on)differ = startTime-now;
                else {
                    
                    QuizResultController.neededtime="00 : "+labelMin.getText()+" : "+zeroLabel.getText()+label.getText();
                    //System.out.println(label.getText());
                    differ=0;
                }
                //System.out.println("In handle " + differ);
                long minutes = (long) (((now - startTime) / 1000.0) / 60.0);               
                long seconds = (long) (((now - startTime) / 1000.0) % 60.0);
                time.set(seconds);
                if(seconds>9)zeroLabel.setText("");
                else zeroLabel.setText("0");
                labelMin.setText(format(minutes));
            }
        };
    }
    @Override
    public void stop(){
        CountTimer.stop();
        System.out.println("Stage is closing");
    }
    @FXML 
    void startStop(ActionEvent e) throws Exception{
            QuizResultController.neededtime="00 : "+labelMin.getText()+" : "+zeroLabel.getText()+label.getText(); 
            CountTimer.stop();
            qz.clear();
            gl.loadUI("quizResult",borderpane);           
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FunListController.centerOfEduCorner="quiz";
        Stage stage = new Stage();
        start(stage);
        if(QuizController.on)CountTimer.start();
        else CountTimer.stop();
        //System.out.println("on " + QuizController.on);
        gl.loadUI(QuizHandle.nextpage,borderpane);
    }
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * 
     * @param stackPane Dialog needs a stackPane
     * @param vbox blur effect will be added on vbox
     * @param event MouseEvent
     * @author 2018331022(Owishi) 
     */
    @FXML void goBack(ActionEvent event) throws IOException{
        if("".equals(QuizHandle.nextpage))gl.loadUI(event, "funList");
        else{
            BoxBlur boxblur = new BoxBlur(3,3,3);
            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            JFXButton goBack = new JFXButton("Go Back");
            JFXButton cancel = new JFXButton("Cancel");
            JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
            goBack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
                try {
                    CountTimer.stop();
                    qz.clear();
                    gl.loadUI(event, "funList");
                } catch (IOException ex) {
                     Logger.getLogger(QuizMultipleChoicesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{            
                dialog.close();
            });
            dialogLayout.setBody(new Text("The test will be undone."));
            dialogLayout.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-font-size: 18 px;");
            goBack.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 18 px;");
            cancel.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 18 px;");
            dialogLayout.setActions(goBack,cancel);
            dialog.show();
            borderpane.setEffect(boxblur);
            dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
            borderpane.setEffect(null);
            }); 
            }
    }
    
    
}
