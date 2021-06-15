package thebabycareproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller of the section ' Book Corner ' of the ' Edu-corner ' category.
 * There are some children story-book provided as pdfs and stored in google drive.
 * List can't be changed or deleted.
 * User should have google drive account to read these pdf books.
 * @author 2018331022(Owishi)
 */
public class BookCornerController implements Initializable {
    GoAndLoad gl = new GoAndLoad();
    
    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button1(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1vGPzoK9lY-LSvQ-DOW8ls1KMUCqhRkBU");
        //openBook("Everyone-has-a-right-to-a-bath-STEM-FKB");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button2(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1y0VgGEyOYHNwRtngHqL5cwgunNqvfQZI");
        //openBook("FKB-Stories-Look-at-me");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button3(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1R4vWKL_3WU7zOD3szotal4ZvPSC2O8h0");
        //openBook("FKB-Stories-bow-meow-wow");
        
    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    }
    @FXML
    void button4(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1oqwcmStu3cSE13LpetxhxxTFCe5y4Xm_");
        //openBook("FKB-Stories-my-body");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button5(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1AK47nzOvc_KV4NzSpKv0QcpckiIdFpqE");
        //openBook("Fables_ckla_g1_u3_reader_FKB");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button6(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1whOGacbRYHMLDLjZ-6feKBjRItWQB9J0");
        //openBook("FKB_Learn-Sight-Words-Print_friendly-Save_the_Planet");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button7(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1eAePDYPx6AVxRzNbukGr9iIJAIxZ1lRu");
        //openBook("Ginger_the_Jiraffe");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button8(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1KGLnLf2YNsvSDnfTOt9pyxF3XXhNLpUS");
        //openBook("The-Inside-Book-Matthew-Griffiths");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button9(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=1NqV7tpLbIjf2iMZiP-ACRYGpADvpatKS");
        //openBook("im-the-colour-of-honey_en_20191124 (1)");
    }

    /**
     * opens pdf using google drive
     * @param event ActionEvent
     * @throws IOException if it is not a HTTPS address
     */
    @FXML
    void button10(ActionEvent event) throws IOException{
        gl.go_to("https://drive.google.com/open?id=14ge6dtDtfpbNh3p0C54Fsw511GTbNJsh");
        //openBook("karabos-question-BookDash-FKB");
    
    }
//    
//    public void openBook(String string){
//        try {
//
//		File pdfFile = new File("src/pdf/"+string+".pdf");
//		if (pdfFile.exists()) {
//
//			if (Desktop.isDesktopSupported()) {
//				Desktop.getDesktop().open(pdfFile);
//			} else {
//				System.out.println("Awt Desktop is not supported!");
//			}
//
//		} else {
//			System.out.println("File is not exists!");
//		}
//
//		System.out.println("Done");
//
//	  } catch (IOException ex) {
//	  }
//    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}

//class PDFOpen extends Application{
//    public void openPDF(){
//        HostServices hs =  getHostServices();
//        hs.showDocument("/pdf/bmi for less than 2.pdf");
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}
