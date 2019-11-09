package com.example.mainactivity.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mainactivity.R;
import com.example.mainactivity.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView tvNameMovie,tvTglMovie,tvDescMovie,tvCrew,tvCrewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent moveIntent = getIntent();
        Movie dataMovie = moveIntent.getParcelableExtra("GET_DATA_MOVIE");
        String movieNameDetail = dataMovie.getNamaMovieDetail();
        String movieTglDetail  = dataMovie.getTglMovieDetail();
        String movieCrewDetail = dataMovie.getCrewMovie();
        String moviePositionDetail = dataMovie.getCrewDetailMovie();
        String movieDescDetail = dataMovie.getDescMovieDetail();

        getSupportActionBar().setTitle(movieNameDetail);

        ImageView imageViewBD = findViewById(R.id.backdrop_detail_movie);
        Glide.with(this)
                .load(dataMovie.getPicture())
                .into(imageViewBD);

        ImageView imageView = findViewById(R.id.image_detail_movie);
        Glide.with(this)
                .load(dataMovie.getPicture())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        tvNameMovie = findViewById(R.id.title_detail_movie);
        tvNameMovie.setText(movieNameDetail);
        tvTglMovie = findViewById(R.id.tgl_detail_movie);
        tvTglMovie.setText(movieTglDetail);
        tvDescMovie = findViewById(R.id.detail_description_movie);
        tvDescMovie.setText(movieDescDetail);
        tvCrew =findViewById(R.id.crew_detail_movie);
        tvCrew.setText(movieCrewDetail);
        tvCrewDetail =findViewById(R.id.position_detail_movie);
        tvCrewDetail.setText(moviePositionDetail);


    }
}
