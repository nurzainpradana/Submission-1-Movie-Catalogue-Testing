package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int tvShowPoster;
    private String tvShowTitle;
    private String tvShowGenre;
    private String tvShowDescription;
    private String tvShowYear;

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        tvShowPoster = in.readInt();
        tvShowTitle = in.readString();
        tvShowGenre = in.readString();
        tvShowDescription = in.readString();
        tvShowYear = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public int getTvShowPoster() {
        return tvShowPoster;
    }

    public void setTvShowPoster(int tvShowPoster) {
        this.tvShowPoster = tvShowPoster;
    }

    public String getTvShowTitle() {
        return tvShowTitle;
    }

    public void setTvShowTitle(String tvShowTitle) {
        this.tvShowTitle = tvShowTitle;
    }

    public String getTvShowGenre() {
        return tvShowGenre;
    }

    public void setTvShowGenre(String tvShowGenre) {
        this.tvShowGenre = tvShowGenre;
    }

    public String getTvShowDescription() {
        return tvShowDescription;
    }

    public void setTvShowDescription(String tvShowDescription) {
        this.tvShowDescription = tvShowDescription;
    }

    public String getTvShowYear() {
        return tvShowYear;
    }

    public void setTvShowYear(String tvShowYear) {
        this.tvShowYear = tvShowYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tvShowPoster);
        dest.writeString(tvShowTitle);
        dest.writeString(tvShowGenre);
        dest.writeString(tvShowDescription);
        dest.writeString(tvShowYear);
    }
}
