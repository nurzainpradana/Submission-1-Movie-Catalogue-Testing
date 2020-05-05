package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailmovie;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie;

public class DetailMovieViewModel extends ViewModel {
    private MutableLiveData<Movie> mMovie = new MutableLiveData<>();

    public static final String EXTRA_MOVIE = "extra_movie";

    MutableLiveData<Movie> getmMovie() {
        return mMovie;
    }

    void setmMovie(Intent intent) {
        Movie movie = intent.getParcelableExtra(EXTRA_MOVIE);
        mMovie.postValue(movie);
    }
}
