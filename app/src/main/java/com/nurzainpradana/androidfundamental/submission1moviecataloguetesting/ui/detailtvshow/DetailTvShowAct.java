package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailtvshow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jgabrielfreitas.core.BlurImageView;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow;

public class DetailTvShowAct extends AppCompatActivity {
    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    TextView tvDetailTvShowTitle, tvDetailTvShowGenre, tvDetailTvShowDescription, tvDetailTvShowYear;
    ImageView ivPoster;
    BlurImageView ivBlurPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        tvDetailTvShowTitle = findViewById(R.id.tv_title_tv_show_detail);
        tvDetailTvShowDescription = findViewById(R.id.tv_description_tv_show_detail);
        tvDetailTvShowGenre = findViewById(R.id.tv_genre_tv_show_detail);
        tvDetailTvShowYear = findViewById(R.id.tv_year_tv_show_detail);
        ivPoster = findViewById(R.id.img_poster_tv_show_detail);
        ivBlurPoster = findViewById(R.id.img_poster_blur_tv_show_detail);

        DetailTvShowViewModel detailTvShowViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailTvShowViewModel.class);
        detailTvShowViewModel.setmTvShow(getIntent());
        detailTvShowViewModel.getmTvShow().observe(this, new Observer<TvShow>() {
            @Override
            public void onChanged(TvShow tvShow) {
                tvDetailTvShowTitle.setText(tvShow.getTvShowTitle());
                tvDetailTvShowYear.setText(tvShow.getTvShowYear());
                tvDetailTvShowDescription.setText(tvShow.getTvShowDescription());
                tvDetailTvShowGenre.setText(tvShow.getTvShowGenre());

                ivPoster.setImageResource(tvShow.getTvShowPoster());
                ivBlurPoster.setImageResource(tvShow.getTvShowPoster());
                ivBlurPoster.setBlur(3);

                String tvShowText = getString(R.string.title_tvshow);

                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null){
                    actionBar.setTitle(tvShowText + " - " + tvShow.getTvShowTitle().toUpperCase());
                }
            }
        });
    }
}
