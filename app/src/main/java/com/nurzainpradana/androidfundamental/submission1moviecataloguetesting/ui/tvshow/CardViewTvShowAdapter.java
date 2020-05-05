package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.tvshow;

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
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow;

import java.util.List;

public class CardViewTvShowAdapter extends RecyclerView.Adapter<CardViewTvShowAdapter.CardViewViewHolder> {
    private List<TvShow> listTvShow;
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    CardViewTvShowAdapter(List<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }
    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_tvshow, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        TvShow tvShow = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getTvShowPoster())
                .apply(new RequestOptions().override(150, 220))
                .into(holder.imgPoster);

        holder.tvTitle.setText(tvShow.getTvShowTitle());
        holder.tvDescription.setText(tvShow.getTvShowDescription());
        holder.tvYear.setText(tvShow.getTvShowYear());
        holder.tvGenre.setText(tvShow.getTvShowGenre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listTvShow.get(holder.getAdapterPosition()));
            }
        });
    }
    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    static class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvYear, tvGenre, tvDescription;


        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_tvshow_item_poster);
            tvTitle = itemView.findViewById(R.id.tv_tvshow_item_title);
            tvYear = itemView.findViewById(R.id.tv_tvshow_item_year);
            tvDescription = itemView.findViewById(R.id.tv_tvshow_item_description);
            tvGenre = itemView.findViewById(R.id.tv_tvshow_item_genre);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShow data);
    }

}
