package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.tvshow;

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
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailtvshow.DetailTvShowAct;
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow;

import java.util.List;
import java.util.Objects;

public class TvshowFragment extends Fragment {

    private RecyclerView rvTvShow;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);

        TvShowViewModel tvShowViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvShowViewModel.class);
        tvShowViewModel.setListTvShow(Objects.requireNonNull(getContext()));

        tvShowViewModel.getListTvShow().observe(getViewLifecycleOwner(), new Observer<List<TvShow>>() {
            @Override
            public void onChanged(List<TvShow> tvShows) {
                showRecyclerCardView(tvShows);
            }
        });
    }

    private void showRecyclerCardView(List<TvShow> tvShows) {
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        CardViewTvShowAdapter cardViewTvShowAdapter = new CardViewTvShowAdapter(tvShows);
        rvTvShow.setAdapter(cardViewTvShowAdapter);


        cardViewTvShowAdapter.setOnItemClickCallback(new CardViewTvShowAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TvShow data) {
                showSelectedTvShow(data);

                Intent gotoDetailTvShow = new Intent(getContext(), DetailTvShowAct.class);
                TvShow mTvShow = new TvShow();
                mTvShow.setTvShowTitle(data.getTvShowTitle());
                mTvShow.setTvShowPoster(data.getTvShowPoster());
                mTvShow.setTvShowYear(data.getTvShowYear());
                mTvShow.setTvShowGenre(data.getTvShowGenre());
                mTvShow.setTvShowDescription(data.getTvShowDescription());
                gotoDetailTvShow.putExtra(DetailTvShowAct.EXTRA_TV_SHOW, mTvShow);
                startActivity(gotoDetailTvShow);
            }
        });
    }

    private void showSelectedTvShow(TvShow tvShow) {
        Toast.makeText(getContext(), "Kamu memilih " + tvShow.getTvShowTitle(), Toast.LENGTH_SHORT).show();
    }
}
