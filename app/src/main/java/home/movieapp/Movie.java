package home.movieapp;

/**
 * Created by Khalil on 6/12/2016.
 */
public class Movie {

    private String title;
    private int rate;
    private String urlImage;
    private String movieReleaseDate;

    public Movie(){

    }


    public Movie(String title, int rate,
             String urlImage,String date){
        this.title=title;
        this.rate=rate;
        this.urlImage=urlImage;
        this.movieReleaseDate=date;
    }


    public String getTitle(){
        return title;
    }

    public int getRate(){
        return rate;
    }

    public String getUrlImage(){
        return urlImage;
    }

    public String getMovieReleaseDate(){
        return movieReleaseDate;
    }

    public void setTitle(String title){
        this.title=title;

    }

    public void setRate(int rate){
        this.rate=rate;
    }

    public void setUrlImage(String urlImage){
        this.urlImage=urlImage;
    }

    public void setMovieReleaseDate(String date){
        this.movieReleaseDate=date;
    }


}


