package thebabycareproject;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Used in many controllers.
 * Loads new images to the provided ImageView and provided size from provided location .
 * @author 2018331022(Owishi)
 */
public class ImageIcon {
    double height,width;
    String path;
    
    /**
     * Constructor 
     * @param height required height of image
     * @param width required width of image
     * @param path path of image
     */
    ImageIcon(double height, double width, String path){
        this.height = height;
        this.width = width;
        this.path = path;
    }
    
    /**
     * Sets certain image on certain ImageView
     * @param s1 name of image
     * @param imageView where to set image
     */
    void setImage(String s1,ImageView imageView){
    File file = new File(path+s1+".png");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);
    imageView.setFitHeight(height);
    imageView.setFitWidth(width);
    }
}
