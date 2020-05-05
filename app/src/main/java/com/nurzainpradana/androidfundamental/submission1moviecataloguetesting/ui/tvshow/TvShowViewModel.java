package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.tvshow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow;

import java.util.ArrayList;
import java.util.List;

class TvShowViewModel extends ViewModel {
    private MutableLiveData<List<TvShow>> listTvShow = new MutableLiveData<>();

    MutableLiveData<List<TvShow>> getListTvShow() {
        return listTvShow;
    }

    void setListTvShow(Context context) {
        String[] dataTvShowTitle = context.getResources().getStringArray(R.array.data_tvShow_title);
        String[] dataTvShowYear = context.getResources().getStringArray(R.array.data_tvShow_year);
        String[] dataTvShowGenre = context.getResources().getStringArray(R.array.data_tvShow_genre);
        String[] dataTvSHowDescription = context.getResources().getStringArray(R.array.data_tvShow_description);
        @SuppressLint("Recycle") TypedArray dataTvShowPoster = context.getResources().obtainTypedArray(R.array.data_tvShow_poster);

        ArrayList<TvShow> listTvShows = new ArrayList<>();
        for (int i = 0; i < dataTvShowTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setTvShowTitle(dataTvShowTitle[i]);
            tvShow.setTvShowDescription(dataTvSHowDescription[i]);
            tvShow.setTvShowGenre(dataTvShowGenre[i]);
            tvShow.setTvShowYear(dataTvShowYear[i]);
            tvShow.setTvShowPoster(dataTvShowPoster.getResourceId(i, -1));

            listTvShows.add(tvShow);
        }

        listTvShow.postValue(listTvShows);

    }
}
