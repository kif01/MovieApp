package home.movieapp;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by Khalil on 6/12/2016.
 */
public class Genre {
    private String type;
    private int image;

    public Genre(String type, int image){
        this.type=type;
        this.image=image;
    }


    public String getName() {
        return type.toString();
    }




    public int getPhoto() {

        return image;
    }


}
