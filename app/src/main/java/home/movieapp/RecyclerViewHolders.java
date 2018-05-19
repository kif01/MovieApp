package home.movieapp;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Khalil on 6/12/2016.
 */
public class RecyclerViewHolders extends RecyclerView.ViewHolder  {

    public TextView type;
    public ImageView genreImage;


    public RecyclerViewHolders(View itemView) {
        super(itemView);
       // itemView.setOnClickListener(this);
        type = (TextView)itemView.findViewById(R.id.country_name);
        genreImage = (ImageView)itemView.findViewById(R.id.genre_image);

    }


   /* @Override
    public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),
                        ChosenGenreActivity.class);
                v.getContext().startActivity(intent);



    }*/
}
