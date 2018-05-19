package home.movieapp;

import android.content.Context;
import android.provider.SyncStateContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Khalil on 6/12/2016.
 */
public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.MoviesViewHolders> {

    private ArrayList<Movie> movieList=new ArrayList<>();
    private LayoutInflater layoutInflater;
    private VolleySingleton mVolleySingleton;
    private ImageLoader mImageLoader;

    public  MoviesRecyclerAdapter(Context context){
        layoutInflater= LayoutInflater.from(context);
        mVolleySingleton = VolleySingleton.getInstance(context);
        mImageLoader = mVolleySingleton.getImageLoader();

    }

    public void setMovieList(ArrayList<Movie> list){
        this.movieList=list;
        notifyItemChanged(0,movieList.size());

    }

    @Override
    public MoviesViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.custom_movie_item,parent,false);
        MoviesViewHolders viewHolder= new MoviesViewHolders(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolders holder, int position) {

        Movie currentMovie=movieList.get(position);
        holder.movieTitle.setText(currentMovie.getTitle());
        holder.movieRate.setRating(currentMovie.getRate()/2.0f);
        holder.movieReleaseDate.setText(currentMovie.getMovieReleaseDate());
        String urlImage=currentMovie.getUrlImage();
        loadImages(urlImage,holder);

    }

    private void loadImages(String urlImage, final MoviesViewHolders holder) {
        if (urlImage!=null) {
            mImageLoader.get(urlImage, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.movieImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MoviesViewHolders extends RecyclerView.ViewHolder {

        private TextView movieTitle;
        private RatingBar movieRate;
        private ImageView movieImage;
        private TextView movieReleaseDate;


        public MoviesViewHolders(View itemView) {
            super(itemView);
            movieTitle= (TextView) itemView.findViewById(R.id.movieTitle);
            movieImage= (ImageView) itemView.findViewById(R.id.movieImage);
            movieRate=(RatingBar) itemView.findViewById(R.id.movieRate);
            movieReleaseDate=(TextView) itemView.findViewById((R.id.release_date));

        }
    }


}


