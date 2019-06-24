package Data;

import Movie.Movie;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieData {
    public static ImmutableList<Movie> getMovieData() throws IOException {
        InputStream inputStream = Resources.getResource("MovieList.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Movie>>() {
        }.getType();
        List<Movie> movies = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(movies);
    }
}
