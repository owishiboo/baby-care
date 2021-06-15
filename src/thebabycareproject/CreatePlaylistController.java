package thebabycareproject;
import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controller of the section ' Create Playlist ' of the ' Edu-corner ' category.
 * User can create and control a list of HTTPS address.
 * Can contain up to 10 addresses.
 * Only HTTPS address(address must contain https, like https://www.xyz.com , www.xyz.com will throw an exception.
 * A dialog box is added in the top left corner to know more about the playlist.
 * Given addresses are saved in local database.
 * @author 2018331022(Owishi)
 */
public class CreatePlaylistController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    @FXML JFXButton but1_plus,but2_plus,but3_plus,but4_plus,but5_plus,but6_plus,but7_plus,but8_plus,but9_plus,but10_plus; 
    @FXML ScrollPane scrollPane;
    @FXML StackPane stackPane;
    @FXML VBox vbox;
    static int position=-1;
    static int[] switcharr={0,0,0,0,0,0,0,0,0,0,0};
    static String[] urlString = new String[11];
    static String[] nameString ={"+","+","+","+","+","+","+","+","+","+","+"};
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but1_plus(ActionEvent event) throws IOException{
        if(switcharr[1]==0){
            position=1;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[1]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but1_del(MouseEvent event){
        if(switcharr[1]!=0)del_functions(1,but1_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but2_plus(ActionEvent event) throws IOException{
        if(switcharr[2]==0){
            position=2;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[2]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but2_del(MouseEvent event){
        if(switcharr[2]!=0)del_functions(2,but2_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but3_plus(ActionEvent event) throws IOException{
        if(switcharr[3]==0){
            position=3;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[3]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but3_del(MouseEvent event){
        if(switcharr[3]!=0)del_functions(3,but3_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but4_plus(ActionEvent event) throws IOException{
        if(switcharr[4]==0){
            position=4;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[4]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but4_del(MouseEvent event){
        if(switcharr[4]!=0)del_functions(4,but4_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but5_plus(ActionEvent event) throws IOException{
        if(switcharr[5]==0){
            position=5;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[5]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but5_del(MouseEvent event){
        if(switcharr[5]!=0)del_functions(5,but5_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but6_plus(ActionEvent event) throws IOException{
        if(switcharr[6]==0){
            position=6;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[6]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but6_del(MouseEvent event){
        if(switcharr[6]!=0)del_functions(6,but6_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but7_plus(ActionEvent event) throws IOException{
        if(switcharr[7]==0){
            position=7;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[7]);        
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but7_del(MouseEvent event){
        if(switcharr[7]!=0)del_functions(7,but7_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but8_plus(ActionEvent event) throws IOException{
        if(switcharr[8]==0){
            position=8;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[8]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but8_del(MouseEvent event){
        if(switcharr[8]!=0)del_functions(8,but8_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but9_plus(ActionEvent event) throws IOException{
        if(switcharr[9]==0){
            position=9;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[9]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but9_del(MouseEvent event){
        if(switcharr[9]!=0)del_functions(9,but9_plus);
    }
    
    /**
     * loads the playlist form if the field is empty
     * else shows the video using default browser
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML 
    void but10_plus(ActionEvent event) throws IOException{
        if(switcharr[10]==0){
            position=10;
            gl.loadUI(event,"playlistForm");
        }
        else gl.go_to(urlString[10]);
    }
    
    /**
     * deletes the enlisted file
     * @param event ActionEvent
     */
    @FXML 
    void but10_del(MouseEvent event){
        if(switcharr[10]!=0)del_functions(10,but10_plus);
    }
    
    /**
     * provides informations about the playlist
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
        dialogLayout.setBody(new Text(
                "Create your own playlist here. Just copy the\n"
                +"HTTPS URL address and give it a suitable\n"
                +"name. You can delete orchange it later.\n"
                +"This list can contain up to 10 files."));
        dialogLayout.setStyle("-fx-background-color: #fce4ec; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        ok.setStyle("-fx-background-color: #FC9D9D; -fx-text-fill: #42070b; -fx-font-size: 18 px;");
        dialogLayout.setActions(ok);
        dialog.show();
        vbox.setEffect(boxblur);
        dialog.setOnDialogClosed((JFXDialogEvent dialogEvent)->{
        vbox.setEffect(null);
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getDB();
            but1_plus.setText(nameString[1]);
            but2_plus.setText(nameString[2]);
            but3_plus.setText(nameString[3]);
            but4_plus.setText(nameString[4]);
            but5_plus.setText(nameString[5]);
            but6_plus.setText(nameString[6]);
            but7_plus.setText(nameString[7]);
            but8_plus.setText(nameString[8]);
            but9_plus.setText(nameString[9]);
            but10_plus.setText(nameString[10]);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePlaylistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * delete operation method
     * @param position index
     * @param button only plus buttons are allowed
     */
    void del_functions(int position,JFXButton button){
        System.out.println("Del button position "+position);
        BoxBlur boxblur = new BoxBlur(3,3,3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXButton yes = new JFXButton("Yes");
        JFXButton no = new JFXButton("No");
        JFXDialog dialog = new JFXDialog(stackPane ,dialogLayout,JFXDialog.DialogTransition.TOP);
        yes.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            try {
                delDB(position);
                switcharr[position]=0;
                nameString[position]="+";
                button.setText("+");
                System.out.println("I deleted "+ position + " no. button and the switcharr value is: "+switcharr[position]);
                dialog.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreatePlaylistController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        no.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{
            System.out.println("I didn't delete "+ position + " no. button and the switcharr value is: "+switcharr[position]);
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

    /**
     * collects data from playlist database
     * @throws SQLException if the database can't be found
     */
    void getDB() throws SQLException{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "");//address userid password
            System.out.println("Connected");  
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM playlist WHERE email='"+LoginPageController.email_txt+"'";
                ResultSet result=statement.executeQuery(sql);
                while(result.next()){
                    for(int i=1;i<=10;i++){
                        String p = result.getString("p"+i);
                        String s = result.getString("s"+i);
                        if(!"0".equals(s)){nameString[i]=s;switcharr[i]=i;
                        urlString[i]=p;
                        System.out.format("%s, %s\n", s, p);
                        }
                    }                    
                }     
            }
    }
    
    /**
     * basically updates the database and deletes the certain file from playlist
     * database will store '0' as address and name for deleted address
     * @param pos index
     * @throws SQLException if database isn't found
     */
    void delDB(int pos) throws SQLException{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java2db", "root", "") //address userid password
            ) {
                System.out.println("Connected");
                String sqlPlaylist = "update playlist set p"+pos+"=? , s"+pos+"=? where email=?";//p=playlist,s=playlist name
                try (PreparedStatement statement = connection.prepareStatement(sqlPlaylist)) {
                    statement.setString(1,"0");//0 means deleted, the name will be changed to '+' sign
                    statement.setString(2,"0");
                    statement.setString(3,LoginPageController.email_txt);
                    statement.executeUpdate();
                    System.out.println("Done delete");
                    
                }
            }
            System.out.println("Done");
    }
}
