package com.example.mainactivity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int picture,backdropPict;
    private String crewMovie,crewDetailMovie,descMovieDetail,namaMovieDetail,tglMovieDetail;

    public Movie(){

    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getBackdropPict() {
        return backdropPict;
    }

    public void setBackdropPict(int backdropPict) {
        this.backdropPict = backdropPict;
    }

    public String getCrewMovie() {
        return crewMovie;
    }

    public void setCrewMovie(String crewMovie) {
        this.crewMovie = crewMovie;
    }

    public String getCrewDetailMovie() {
        return crewDetailMovie;
    }

    public void setCrewDetailMovie(String crewDetailMovie) {
        this.crewDetailMovie = crewDetailMovie;
    }

    public String getDescMovieDetail() {
        return descMovieDetail;
    }

    public void setDescMovieDetail(String descMovieDetail) {
        this.descMovieDetail = descMovieDetail;
    }

    public String getNamaMovieDetail() {
        return namaMovieDetail;
    }

    public void setNamaMovieDetail(String namaMovieDetail) {
        this.namaMovieDetail = namaMovieDetail;
    }

    public String getTglMovieDetail() {
        return tglMovieDetail;
    }

    public void setTglMovieDetail(String tglMovieDetail) {
        this.tglMovieDetail = tglMovieDetail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(picture);
        dest.writeInt(backdropPict);
        dest.writeString(crewMovie);
        dest.writeString(crewDetailMovie);
        dest.writeString(descMovieDetail);
        dest.writeString(namaMovieDetail);
        dest.writeString(tglMovieDetail);
    }


    protected Movie(Parcel in) {
        picture = in.readInt();
        backdropPict = in.readInt();
        crewMovie = in.readString();
        crewDetailMovie = in.readString();
        descMovieDetail = in.readString();
        namaMovieDetail = in.readString();
        tglMovieDetail = in.readString();
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
}
