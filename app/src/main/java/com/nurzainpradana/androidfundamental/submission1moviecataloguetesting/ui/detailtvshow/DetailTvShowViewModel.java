package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailtvshow;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow;

import static com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailtvshow.DetailTvShowAct.EXTRA_TV_SHOW;

public class DetailTvShowViewModel extends ViewModel {
    MutableLiveData<TvShow> mTvShow = new MutableLiveData<>();

    public MutableLiveData<TvShow> getmTvShow() {
        return mTvShow;
    }

    public void setmTvShow(Intent intent) {
        TvShow TvShow = intent.getParcelableExtra(EXTRA_TV_SHOW);
        mTvShow.postValue(TvShow);
    }
}
