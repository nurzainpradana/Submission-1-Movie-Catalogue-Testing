package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int moviePoster;
    private String movieTitle;
    private String movieGenre;
    private String movieDescription;
    private String movieYear;

    public Movie() {
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Movie(Parcel in){
        moviePoster = in.readInt();
        movieTitle = in.readString();
        movieGenre = in.readString();
        movieDescription = in.readString();
        movieYear = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(moviePoster);
        dest.writeString(movieTitle);
        dest.writeString(movieGenre);
        dest.writeString(movieDescription);
        dest.writeString(movieYear);
    }

}
