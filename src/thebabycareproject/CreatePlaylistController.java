package thebabycareproject;
import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class CreatePlaylistController implements Initializable {
    @FXML public JFXButton but1_plus,but2_plus,but3_plus,but4_plus,but5_plus,but6_plus,but7_plus; 
    @FXML ScrollPane scrollPane;
    @FXML StackPane stackPane;
    public static int position=-1;
    public static int[] switcharr={0,0,0,0,0,0,0,0};
    public static String[] urlString = new String[8];
    public static String[] nameString ={"+","+","+","+","+","+","+","+"};
    @FXML 
    public void but1_plus(ActionEvent event) throws IOException{
        position = 1;
        plus_functions(position,event);    
    }@FXML 
    public void but1_del(ActionEvent event) throws IOException{
        if(switcharr[1]!=0)del_functions(1,but1_plus);
    }
    @FXML 
    public void but2_plus(ActionEvent event) throws IOException{
        position = 2;
        plus_functions(position,event);
    }@FXML 
    public void but2_del(ActionEvent event) throws IOException{
        if(switcharr[2]!=0)del_functions(2,but2_plus);
    }
    @FXML 
    public void but3_plus(ActionEvent event) throws IOException{
        position = 3;
        plus_functions(position,event);
    }@FXML 
    public void but3_del(ActionEvent event) throws IOException{
        if(switcharr[3]!=0)del_functions(3,but3_plus);
    }
    @FXML 
    public void but4_plus(ActionEvent event) throws IOException{
        position = 4;
        plus_functions(position,event);
    }@FXML 
    public void but4_del(ActionEvent event) throws IOException{
        if(switcharr[4]!=0)del_functions(4,but4_plus);
    }
    @FXML 
    public void but5_plus(ActionEvent event) throws IOException{
        position = 5;
        plus_functions(position,event);
    }@FXML 
    public void but5_del(ActionEvent event) throws IOException{
        if(switcharr[5]!=0)del_functions(5,but5_plus);
    }
    @FXML 
    public void but6_plus(ActionEvent event) throws IOException{
        position = 6;
        plus_functions(position,event);
    }@FXML 
    public void but6_del(ActionEvent event) throws IOException{
        if(switcharr[6]!=0)del_functions(6,but6_plus);
    }
    @FXML 
    public void but7_plus(ActionEvent event) throws IOException{
        position = 7;
        plus_functions(position,event);
    }@FXML 
    public void but7_del(ActionEvent event) throws IOException{
        if(switcharr[7]!=0)del_functions(7,but7_plus);
    }
    public void plus_functions(int position,ActionEvent event) throws IOException{
        System.out.println("Plus button position "+position);
        if(switcharr[position]==0){
            System.out.println("switcharr value of the button "+switcharr[position]);
            switcharr[position]=position;
            callPlaylistForm(event);
        }
        else{
            System.out.println("switcharr value of the button "+switcharr[position]);
            System.out.println("Now calling to play video and the link "+urlString[position]);
            go_to(urlString[position]);
        }
    }
    public void del_functions(int position,JFXButton button){
        System.out.println("Del button position "+position);
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton yes = new JFXButton("Yes");
        JFXButton no = new JFXButton("No");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        yes.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            switcharr[position]=0;
            nameString[position]="+";
            button.setText("+");
        System.out.println("I deleted "+ position + "no. button and the switcharr value is: "+switcharr[position]);
            dialog.close();
        });
        no.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            System.out.println("I didn't delete "+ position + "no. button and the switcharr value is: "+switcharr[position]);
            dialog.close();
        });
        dialogLayout.setBody(new Text("Are you sure to delete this file?"));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        yes.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        no.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18px;");
        dialogLayout.setActions(yes,no);
        dialog.show();
        scrollPane.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        scrollPane.setEffect(null);
        });
        System.out.println("switcharr value of the button "+switcharr[position]);
    }
    public void callPlaylistForm(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("playlistForm.fxml"));
         Scene home_page = new Scene(pane);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(home_page);
         stage.show(); 
    }
//    public void setButton(int position){                
//        if(position==-1) {
//        } 
//        JFXButton button = null;
//        //,,but3_plus,but4_plus,but5_plus,but6_plus,but7_plus
//        switch (position) {
//            case 1:
//                button=but1_plus;
//                break;
//            case 2:
//                button=but2_plus;
//                break;
//            case 3:
//                button=but3_plus;
//                break;
//            case 4:
//                button=but4_plus;
//                break;
//            case 5:
//                button=but5_plus;
//                break;
//            case 6:
//                button=but6_plus;
//                break;
//            case 7:
//                button=but7_plus;
//                break;
//            default:
//                break;
//        }
//        button.setText(nameString[position]);
//
//    }
    public void go_to(String site) throws IOException{
            try {
            Desktop.getDesktop().browse(new URI(site));
            } catch (URISyntaxException e1) {
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        but1_plus.setText(nameString[1]);
        but2_plus.setText(nameString[2]);
        but3_plus.setText(nameString[3]);
        but4_plus.setText(nameString[4]);
        but5_plus.setText(nameString[5]);
        but6_plus.setText(nameString[6]);
        but7_plus.setText(nameString[7]);
    }    
    
}
