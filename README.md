# MovieSearch
## Project Description
Given a word (or phrase) search a given JSON object.
The purpose of this search is to return the title of a movie when a word or phrase is passed. 
The provided search term should be searched in all values of the object, 
returning the title(s) wherever the searched term is present.
At the end it should also show how many times the term was present.

## Running the Project:
- Click the Run Button or press shift+F10.
- Enter the word (or phrase) you wish to search in a given JSON object.
- The output should be title(s) of the movie(s) where the provided search term is present.
- The outout also includes how many times the term was present.

## How Project was Built:
### MovieData.java Class getMovieData() method converts Movies in the json file into ImmutableList<Movie>.
### Movie.java Class is the constructer class for Movie type. 
### Exercise.java Class contains the main method to run the project.
- User would input word (or phrase) into project as it is ran.
- The input goes through matchingInput method that prints out the list of Movies without duplications,
where the input was present in either any of the movies's title, cast members, and genre.
- The matchingInput method uses matchingTitle, matchingCast, and matchingGenre to filter movies.
- The methods matchingTitle, matchingCast, and matchingGenre check if the input was ever contained
in any of the Movies titles, casts, and genres.
- If the input was contained, the movie in correspondense will be added to a List<String> called myList.
- Also, if the input was contained, the counter for how many times the input was present increases by one.
- After comparing the input with every movies title, cast, and genre, myList is then filtered out to remove any duplicatation of the same movies, myList is printed out alongside the number of time input was present.
