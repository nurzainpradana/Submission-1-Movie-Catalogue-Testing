package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailmovie.DetailMovieAct;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie;

import java.util.List;
import java.util.Objects;

import static com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailmovie.DetailMovieViewModel.EXTRA_MOVIE;

public class MoviesFragment extends Fragment {

    private RecyclerView rvMovies;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        MovieViewModel movieViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MovieViewModel.class);
        movieViewModel.setListMovie(Objects.requireNonNull(getContext()));

        movieViewModel.getListMovie().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                showRecyclerCardView(movies);
            }
        });
    }

    private void showRecyclerCardView(List<Movie> movies) {
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        CardViewMovieAdapter cardViewMovieAdapter = new CardViewMovieAdapter(movies);
        rvMovies.setAdapter(cardViewMovieAdapter);

        cardViewMovieAdapter.setOnItemClickCallback(new CardViewMovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showSelectedMovie(data);

                Intent gotoDetailMovie = new Intent(getContext(), DetailMovieAct.class);
                Movie mMovie = new Movie();
                mMovie.setMovieTitle(data.getMovieTitle());
                mMovie.setMoviePoster(data.getMoviePoster());
                mMovie.setMovieYear(data.getMovieYear());
                mMovie.setMovieGenre(data.getMovieGenre());
                mMovie.setMovieDescription(data.getMovieDescription());
                gotoDetailMovie.putExtra(EXTRA_MOVIE, mMovie);
                startActivity(gotoDetailMovie);
            }
        });

    }
    private void showSelectedMovie(Movie movie){
        Toast.makeText(getContext(), "Kamu memilih " + movie.getMovieTitle(), Toast.LENGTH_SHORT).show();
    }
}
