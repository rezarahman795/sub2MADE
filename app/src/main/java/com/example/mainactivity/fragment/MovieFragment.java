package com.example.mainactivity.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainactivity.R;
import com.example.mainactivity.adapter.MovieAdapter;
import com.example.mainactivity.detail.MovieDetailActivity;
import com.example.mainactivity.model.Movie;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rv_movies;
    private ArrayList<Movie>list = new ArrayList<>();


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        rv_movies = view.findViewById(R.id.rv_movie);
        rv_movies.setHasFixedSize(true);



        list.addAll(getListMovie());

        showRecyclerMovie();
    }

    public ArrayList<Movie> getListMovie() {
        String[]dataNameMovie =getResources().getStringArray(R.array.data_name_movie);
        String[]dataTglMovie=getResources().getStringArray(R.array.data_tgl_movie);
        TypedArray imgMovie = getResources().obtainTypedArray(R.array.data_picture);
        String[]dataCrew = getResources().getStringArray(R.array.data_name_crew);
        String[]dataCrewDetail = getResources().getStringArray(R.array.detail_position);
        String[]dataDescMovie = getResources().getStringArray(R.array.data_description_detail);

        ArrayList<Movie> listDataMovie = new ArrayList<>();

        for (int i = 0 ; i<imgMovie.length();i++){
            Movie movie = new Movie();
            movie.setNamaMovieDetail(dataNameMovie[i]);
            movie.setTglMovieDetail(dataTglMovie[i]);
            movie.setDescMovieDetail(dataDescMovie[i]);
            movie.setCrewMovie(dataCrew[i]);
            movie.setCrewDetailMovie(dataCrewDetail[i]);
            movie.setPicture(imgMovie.getResourceId(i,-1));

            listDataMovie.add(movie);

        }
        return listDataMovie;

    }

    private void showRecyclerMovie() {
        rv_movies.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter movieAdapter= new MovieAdapter(list);
        rv_movies.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie dataMovie) {

                showSelectedMovie(dataMovie);


            }
        });
    }

    private void showSelectedMovie(Movie detailDataMovie) {
        Intent movieDetail = new Intent(getContext(), MovieDetailActivity.class);
        movieDetail.putExtra("GET_DATA_MOVIE", detailDataMovie);
        startActivity(movieDetail);
        getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

}
