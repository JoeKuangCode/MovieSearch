package Files;

import Movie.Movie;
import Data.MovieData;
import com.google.common.collect.ImmutableList;

import javax.swing.*;
import java.util.*;

public class Exercise
{
    private static int counter;

    public static void main(String[] args) throws Exception {
        final JFrame parent = new JFrame();
        parent.pack();
        parent.setVisible(true);
        String input = JOptionPane.showInputDialog(parent,
                "What is your search term?", null);
        System.out.println("Input \"Search Term\" : " + input);
        matchingInput(input);
        System.out.println("count: " + getCounter());
    }

    private Exercise(int counter) {
        Exercise.counter = counter;
    }

    private static int getCounter() {
        return counter;
    }

    private static void matchingInput(String input) throws Exception {
        List<String> myList = new ArrayList<>();
        for (int i = 0; i < matchingTitle(input).size(); i++){
            myList.add(matchingTitle(input).get(i).getTitle());
            if(matchingTitle(input).get(i).getTitle().contains(input)){
                counter++;
            }
        }
        for (int i = 0; i < matchingCast(input).size(); i++){
            myList.add(matchingCast(input).get(i).getTitle());
            for (int j = 0; j < matchingCast(input).get(i).getCast().size(); j++)
                if(matchingCast(input).get(i).getCast().get(j).contains(input)) {
                  counter++;
                }
        }
        for (int i = 0; i < matchingGenres(input).size(); i++){
            myList.add(matchingGenres(input).get(i).getTitle());
            for (int j = 0; j < matchingGenres(input).get(i).getGenres().size(); j++)
                if(matchingGenres(input).get(i).getGenres().get(j).contains(input)) {
                    counter++;
                }
        }
        Set<String> set = new TreeSet<>(myList);
        List<String> listWithoutDuplicates = new ArrayList<>(set);
        System.out.println("Output \"Movie(s)\" : " + listWithoutDuplicates.toString().substring(1,listWithoutDuplicates.toString().length()-1));
    }

    private static List<Movie> matchingTitle(String title) throws Exception {
        ImmutableList<Movie> Movies = MovieData.getMovieData();
        List<Movie> matchedMovies = new ArrayList<Movie>();
        for (int i = 0; i < Movies.size(); i++) {
            if (Movies.get(i).getTitle().contains(title)) {
                matchedMovies.add(Movies.get(i));
            }
        }
        return matchedMovies;
    }

    private static List<Movie> matchingCast(String cast) throws Exception {
        ImmutableList<Movie> Movies = MovieData.getMovieData();
        List<Movie> matchedMovies = new ArrayList<Movie>();
        for (int i = 0; i < Movies.size(); i++) {
            if (Movies.get(i).getCast().toString().contains(cast)) {
                matchedMovies.add(Movies.get(i));
            }
        }
        return matchedMovies;
    }

    private static List<Movie> matchingGenres(String genres) throws Exception {
        ImmutableList<Movie> Movies = MovieData.getMovieData();
        List<Movie> matchedMovies = new ArrayList<Movie>();
        for (int i = 0; i < Movies.size(); i++) {
            if (Movies.get(i).getGenres().toString().contains(genres)) {
                matchedMovies.add(Movies.get(i));
            }
        }
        return matchedMovies;
    }
}