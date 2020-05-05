package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailmovie;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jgabrielfreitas.core.BlurImageView;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie;

public class DetailMovieAct extends AppCompatActivity {

    TextView tvDetailMovieTitle, tvDetailMovieGenre, tvDetailMovieDescription, tvDetailMovieYear;
    ImageView ivPoster;
    BlurImageView ivBlurPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvDetailMovieTitle = findViewById(R.id.tv_title_movie_detail);
        tvDetailMovieDescription = findViewById(R.id.tv_description_movie_detail);
        tvDetailMovieGenre = findViewById(R.id.tv_genre_movie_detail);
        tvDetailMovieYear = findViewById(R.id.tv_year_movie_detail);
        ivPoster = findViewById(R.id.img_poster_movie_detail);
        ivBlurPoster = findViewById(R.id.img_poster_blur_movie_detail);

        DetailMovieViewModel detailMovieViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailMovieViewModel.class);
        detailMovieViewModel.setmMovie(getIntent());

        detailMovieViewModel.getmMovie().observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(Movie movie) {
                if (movie != null) {
                    tvDetailMovieTitle.setText(movie.getMovieTitle());
                    tvDetailMovieYear.setText(movie.getMovieYear());
                    tvDetailMovieDescription.setText(movie.getMovieDescription());
                    tvDetailMovieGenre.setText(movie.getMovieGenre());

                    ivPoster.setImageResource(movie.getMoviePoster());
                    ivBlurPoster.setImageResource(movie.getMoviePoster());
                    ivBlurPoster.setBlur(3);

                    String movieText = getString(R.string.title_movies);

                    ActionBar actionBar = getSupportActionBar();
                    if (actionBar != null) {
                        actionBar.setTitle(movieText + " - " + movie.getMovieTitle().toUpperCase());
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
