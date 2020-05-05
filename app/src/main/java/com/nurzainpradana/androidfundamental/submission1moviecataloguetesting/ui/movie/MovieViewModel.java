package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.movie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> getListMovie() {
        return listMovie;
    }

    public void setListMovie(Context context) {
        String[] dataMovieTitle = context.getResources().getStringArray(R.array.data_movie_title);
        String[] dataMovieYear = context.getResources().getStringArray(R.array.data_movie_year);
        String[] dataMovieGenre = context.getResources().getStringArray(R.array.data_movie_genre);
        String[] dataMovieDescription = context.getResources().getStringArray(R.array.data_movie_description);
        @SuppressLint("Recycle") TypedArray dataMoviePoster = context.getResources().obtainTypedArray(R.array.data_movie_poster);

        ArrayList<Movie> listMovies = new ArrayList<>();
        for (int i = 0; i < dataMovieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setMovieTitle(dataMovieTitle[i]);
            movie.setMovieDescription(dataMovieDescription[i]);
            movie.setMovieGenre(dataMovieGenre[i]);
            movie.setMovieYear(dataMovieYear[i]);
            movie.setMoviePoster(dataMoviePoster.getResourceId(i,-1));

            listMovies.add(movie);
        }
        listMovie.postValue(listMovies);
    }
}
