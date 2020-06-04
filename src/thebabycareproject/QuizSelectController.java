package thebabycareproject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleNode;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Controller of the subsection ' quizSelect ' of the section ' Quiz ' of the ' Edu-care ' category.
 * Provides four options with images. Answer the question by choosing one. 
 * @author 2018331022(Owishi)
 */
public class QuizSelectController implements Initializable {
    QuizHandle qz = new QuizHandle(QuizController.type);
    ImageIcon ic = new ImageIcon(100.0,100.0,"src/image/");
    GoAndLoad gl = new GoAndLoad();
    Random random = new Random();
    
    ArrayList<JFXToggleNode> toggleNodeList = new ArrayList<>();
    ArrayList<ImageView> imageViewlist = new ArrayList<>();
    static ArrayList<ArrayList<String> > quesSelect=  new ArrayList< >();

    String imageNameList[] = new String[4];
    int pos;
    static int count=0;
    
    @FXML Label label;
    @FXML JFXToggleNode t1,t2,t3,t4;
    @FXML ImageView i1,i2,i3,i4;
    @FXML JFXButton next; 
    @FXML VBox vbox1,vbox;
    @FXML StackPane stackPane;
    
    /**
     * Loads ' Fun and Learn ' in the center of BorderPane
     * @param event MouseEvent on ImageView
     */
    @FXML
    void goBack(MouseEvent event){
        qz.goBackFunctions(stackPane, vbox, event);
    }
    
    /**
     * Changes text color of question and 'next' button
     * @param event MouseEvent on Label
     */
    @FXML
    void changeTextColor(MouseEvent event){
        qz.changeTextColor(label, next);
    }
    
    /**
     * Loads next type of question or ' Quiz Result '
     * @param event ActionEvent
     * @throws IOException if fxml is not found
     */
    @FXML
    void next(ActionEvent event) throws IOException{
        boolean id = false;
        count++;
        if(count==QuizHandle.limit){
             for(int i=0;i<toggleNodeList.size();i++){
                if(toggleNodeList.get(i).isSelected()){
                    id = true;
                    QuizHandle.givenAnswer.add(imageNameList[i].toUpperCase());
                    //System.out.println(imageNameList[i]);
                }
                toggleNodeList.get(i).setSelected(false);
            }
            if(!id)QuizHandle.givenAnswer.add("");
            quesSelect.clear();
            gl.loadUI(event, QuizHandle.nextpage);
        }
        else{
            Color c = qz.generateLightColor();
            String red = c.toString().substring(17, 20);
            String green = c.toString().substring(23, 26);
            String blue = c.toString().substring(29, 32);
            vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
            next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
            for(int i=0;i<toggleNodeList.size();i++){
                if(toggleNodeList.get(i).isSelected()){
                    id = true;
                    //System.out.println(imageNameList[i]);
                    QuizHandle.givenAnswer.add(imageNameList[i].toUpperCase());
                }
                toggleNodeList.get(i).setSelected(false);
            }
            if(!id)QuizHandle.givenAnswer.add("");
            
            quesSelect.remove(pos);
            pos = random.nextInt(quesSelect.size());
            chooseRandom(pos);
        }
    }        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println("Select");
        qz.callSelect();  
        qz.loadTextColor(label, next);
        String red = qz.generateLightColor().toString().substring(17, 20);
        String green = qz.generateLightColor().toString().substring(23, 26);
        String blue = qz.generateLightColor().toString().substring(29, 32);
        vbox1.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
        next.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue +")");
        
        toggleNodeList.add(t1);
        toggleNodeList.add(t2);
        toggleNodeList.add(t3);
        toggleNodeList.add(t4);
        
        imageViewlist.add(i1);
        imageViewlist.add(i2);
        imageViewlist.add(i3);
        imageViewlist.add(i4);
        
        pos = random.nextInt(quesSelect.size());
        chooseRandom(pos);    
    }
    
    /**
     * Randomly chooses next question and sets images for the options randomly from certain questionList
     * @param pos a random number according to the size of the questionList
     */
    void chooseRandom(int pos){
        ArrayList< String > s = new ArrayList<>();
        s.add(quesSelect.get(pos).get(0));
        s.add(quesSelect.get(pos).get(1).toUpperCase());
        QuizHandle.correctAnswerList.add(s);
        
        label.setText(quesSelect.get(pos).get(0));
        for(int i=0;i<toggleNodeList.size();i++){
            int k = random.nextInt(quesSelect.get(pos).size());
            if(k==0)k=1;
            ic.setImage(quesSelect.get(pos).get(k),imageViewlist.get(i));
            imageNameList[i] = quesSelect.get(pos).get(k);
            System.out.println(imageNameList[i]);
            quesSelect.get(pos).remove(k);
        }      
    }
}