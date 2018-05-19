package home.movieapp;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static android.widget.Toast.*;

public class ChosenGenreActivity extends AppCompatActivity {

    private MoviesRecyclerAdapter moviesRecyclerAdapter;
    private RecyclerView movieList;
    private ArrayList<Movie> listMovies = new ArrayList<>();
    private RequestQueue requestQueue;
    private VolleySingleton volleySingleton;
    private ProgressBar progressBar_loadingImage;


    final String SCIFI = "878";
    final String COMEDY = "35";
    final String ACTION = "28";
    final String HORROR = "27";
    final String ANIMATION = "16";
    final String ADVENTURE = "12";
    final String DRAMA = "18";
    final String DOCUMENTARY = "99";
    int pageCount = 1;
    final String part1 = "http://api.themoviedb.org/3/genre/";
    final String part2 = "/movies?api_key=edb305efd0db38ca38ac0d80bd22a4ed&page=";
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    String url;
    int genre;

    final String API = "edb305efd0db38ca38ac0d80bd22a4ed";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_genre);

        progressBar_loadingImage = (ProgressBar) findViewById(R.id.progressBar_loadingImage);
        movieList = (RecyclerView) findViewById(R.id.genre_recycle_list);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        movieList.setLayoutManager(linearLayoutManager);
        moviesRecyclerAdapter = new MoviesRecyclerAdapter(this);
        movieList.setAdapter(moviesRecyclerAdapter);

        volleySingleton = VolleySingleton.getInstance(this);
        requestQueue = volleySingleton.getRequestQueue();
       // int genre = getIntent().getIntExtra("genre", 0);
        genre=getIntent().getIntExtra("genre", 0);














        switch (genre) {
            case 0:
                url = part1 + SCIFI + part2 + pageCount;
                sendJsonRequest(url);

           case 1:
                url = part1 + COMEDY + part2 + pageCount;
                sendJsonRequest(url);
                break;
            case 2:
                url = part1 + ACTION + part2 + pageCount;
                sendJsonRequest(url);
                break;

            case 3:
                url = part1 + HORROR + part2 + pageCount;
                sendJsonRequest(url);
                break;

            case 4:
                url = part1 + ANIMATION + part2 + pageCount;
                sendJsonRequest(url);
                break;

            case 5:
                url = part1 + ADVENTURE + part2 + pageCount;
                sendJsonRequest(url);
                break;

            case 6:
                url = part1 + DRAMA + part2 + pageCount;
                sendJsonRequest(url);
                break;

            case 7:
                url = part1 + DOCUMENTARY + part2 + pageCount;
                sendJsonRequest(url);
                break;



        }



        movieList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) //check for scroll down
                {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {

                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                           // loading = false;
                            progressBar_loadingImage.setVisibility(View.VISIBLE);
                            genre = getIntent().getIntExtra("genre", 0);
                            switch (genre) {
                                case 0:
                                    url = part1 + SCIFI + part2 + pageCount;
                                    sendJsonRequest(url);
                                    moviesRecyclerAdapter.notifyItemInserted(listMovies.size()-1);
                                    moviesRecyclerAdapter.notifyDataSetChanged();

                                case 1:
                                    url = part1 + COMEDY + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;
                                case 2:
                                    url = part1 + ACTION + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;

                                case 3:
                                    url = part1 + HORROR + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;

                                case 4:
                                    url = part1 + ANIMATION + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;

                                case 5:
                                    url = part1 + ADVENTURE + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;

                                case 6:
                                    url = part1 + DRAMA + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;

                                case 7:
                                    url = part1 + DOCUMENTARY + part2 + pageCount;
                                    sendJsonRequest(url);
                                    break;



                            }



                           //
                        }
                    }
                }
            }
        });



       /* movieList.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {

                int genre = getIntent().getIntExtra("genre", 0);
                String url;


                Log.d("test", "" + current_page);
                url = part1 + SCIFI + part2 + current_page;
                Log.d("test1",""+url);
                sendJsonRequest(url);
            }
        });*/


        // int genre = getIntent().getIntExtra("genre", 0);
        //pageCount++;
        //Toast.makeText(this.,""+pageCount,LENGTH_LONG).show();
        //Log.d("test",""+pageCount);
                /*String url;
                switch (genre) {
                    case 0:
                        url = part1 + SCIFI + part2 + pageCount;
                        sendJsonRequest(url);
                    case 1:
                        url = part1 + COMEDY + part2 + pageCount;
                        sendJsonRequest(url);
                        break;
                    case 2:
                        url = part1 + ACTION + part2 + pageCount;
                        sendJsonRequest(url);
                        break;

                    case 3:
                        url = part1 + HORROR + part2 + pageCount;
                        sendJsonRequest(url);
                        break;

                    case 4:
                        url = part1 + ANIMATION + part2 + pageCount;
                        sendJsonRequest(url);
                        break;

                    case 5:
                        url = part1 + ADVENTURE + part2 + pageCount;
                        sendJsonRequest(url);
                        break;

                    case 6:
                        url = part1 + DRAMA + part2 + pageCount;
                        sendJsonRequest(url);
                        break;

                    case 7:
                        url = part1 + DOCUMENTARY + part2 + pageCount;
                        sendJsonRequest(url);
                        break;

                }*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }


        /*switch (genre){
            case 0:
                url=part1+SCIFI+part2;
                sendJsonRequest(url);
            case 1:
                url=part1+COMEDY+part2;
                sendJsonRequest(url);
                break;
            case 2:
                url=part1+ACTION+part2;
                sendJsonRequest(url);
                break;

            case 3:
                url=part1+HORROR+part2;
                sendJsonRequest(url);
                break;

            case 4:
                url=part1+ANIMATION+part2;
                sendJsonRequest(url);
                break;

            case 5:
                url=part1+ADVENTURE+part2;
                sendJsonRequest(url);
                break;

            case 6:
                url=part1+DRAMA+part2;
                sendJsonRequest(url);
                break;

            case 7:
                url=part1+DOCUMENTARY+part2;
                sendJsonRequest(url);
                break;


        }*/
    // sendJsonRequest(url);


    private void sendJsonRequest(String url) {
        //String url = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=edb305efd0db38ca38ac0d80bd22a4ed";
        //String url2="http://api.themoviedb.org/3/genre/878/movies?api_key=edb305efd0db38ca38ac0d80bd22a4ed";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listMovies = parseJsonResponse(response);
                moviesRecyclerAdapter.setMovieList(listMovies);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                makeText(getBaseContext(), "error");

            }
        });
        requestQueue.add(request);


        pageCount++;
    }

    private static void makeText(Context ctxt, String response) {
        Toast.makeText(ctxt, response, Toast.LENGTH_LONG).show();
    }

    private ArrayList<Movie> parseJsonResponse(JSONObject response) {
        ArrayList<Movie> listMovies = new ArrayList<>();
        if (response != null || response.length() > 0) {
            try {
                JSONArray moviesArray = response.getJSONArray("results");

                for (int i = 0; i < moviesArray.length(); i++) {
                    JSONObject currentMovie = moviesArray.getJSONObject(i);
                    String title = currentMovie.getString("original_title");
                    String posterURL = currentMovie.getString("poster_path");
                    String movieDate = currentMovie.getString("release_date");


                    int rate = currentMovie.getInt("vote_average");

                    Movie movie = new Movie();

                    movie.setTitle(title);
                    movie.setRate(rate);
                    movie.setMovieReleaseDate(movieDate);
                    movie.setUrlImage("https://image.tmdb.org/t/p/w300" + posterURL);

                    listMovies.add(movie);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        progressBar_loadingImage.setVisibility(View.INVISIBLE);
        return listMovies;


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ChosenGenre Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://home.movieapp/http/host/path")
        );

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ChosenGenre Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://home.movieapp/http/host/path")
        );

    }


   /* private void sortByGenre(int genre,String url){
        switch (genre){
            case 0:
                url=part1+SCIFI+part2;
                sendJsonRequest(url);
            case 1:
                url=part1+COMEDY+part2;
                sendJsonRequest(url);
                break;
            case 2:
                url=part1+ACTION+part2;
                sendJsonRequest(url);
                break;

            case 3:
                url=part1+HORROR+part2;
                sendJsonRequest(url);
                break;

            case 4:
                url=part1+ANIMATION+part2;
                sendJsonRequest(url);
                break;

            case 5:
                url=part1+ADVENTURE+part2;
                sendJsonRequest(url);
                break;

            case 6:
                url=part1+DRAMA+part2;
                sendJsonRequest(url);
                break;

            case 7:
                url=part1+DOCUMENTARY+part2;
                sendJsonRequest(url);
                break;


        }
    }*/


}