package Movie;

import java.util.ArrayList;

public class Movie {

    private String title;
    private ArrayList<String> cast;
    private ArrayList<String> genres;

    public Movie(String title, ArrayList<String> cast, ArrayList<String> genres) {
        this.title = title;
        this.cast = cast;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() { return cast; }

    public ArrayList<String> getGenres() { return genres; }

    public String toString(){
        return "Movie(s):" + title + '\n';
    }

}
