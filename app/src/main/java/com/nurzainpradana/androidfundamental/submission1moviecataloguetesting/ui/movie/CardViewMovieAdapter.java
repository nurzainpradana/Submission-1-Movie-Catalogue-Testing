package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie;

import java.util.List;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder> {
    private List<Movie> listMovie;

    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    CardViewMovieAdapter(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CardViewMovieAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_movie, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getMoviePoster())
                .apply(new RequestOptions().override(150, 220))
                .into(holder.imgPoster);

        holder.tvTitle.setText(movie.getMovieTitle());
        holder.tvDescription.setText(movie.getMovieDescription());
        holder.tvGenre.setText(movie.getMovieGenre());
        holder.tvYear.setText(movie.getMovieYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
                //MoviesFragmentDirections.ActionNavigationMoviesToDetailMovieAct toDetailMovieAct = MoviesFragmentDirections.actionNavigationMoviesToDetailMovieAct();
                //toDetailMovieAct.setMovieTitle(movie.getMovieTitle());



            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    static class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvYear, tvGenre, tvDescription;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_movie_item_poster);
            tvTitle = itemView.findViewById(R.id.tv_movie_item_title);
            tvDescription = itemView.findViewById(R.id.tv_movie_item_description);
            tvGenre = itemView.findViewById(R.id.tv_movie_item_genre);
            tvYear = itemView.findViewById(R.id.tv_movie_item_year);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie data);
    }
}

