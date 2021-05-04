package com.example.moblabhw.view.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.moblabhw.R
import com.example.moblabhw.databinding.ActivityDetailsBinding
import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.util.DataState
import com.example.moblabhw.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    companion object {
        const val KEY_MOVIE = "KEY_MOVIE"
    }

    private val detailsViewModel: DetailsViewModel by viewModels()
    private var movieId = 0

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // https://stackoverflow.com/questions/26651602/display-back-arrow-on-toolbar
        setSupportActionBar(findViewById(R.id.details_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        movieId = intent.getIntExtra(KEY_MOVIE,0)
        detailsViewModel.getDetails(movieId)
        detailsViewModel.movieDetails.observe(this, Observer { dataState ->
            when(dataState){
                is DataState.Success -> {
                    Log.d("DETAILS", "Success")
                    showDetails(dataState.data)
                    binding.detailsContent.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
                is DataState.Error -> {
                    Log.d("DETAILS", dataState.exception.message.toString())
                    binding.progressBar.visibility = View.GONE
                }
                is DataState.Loading -> {
                    Log.d("DETAILS", "Loading")
                    binding.detailsContent.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
        detailsViewModel.isFavorite.observe(this, Observer { isFavorite ->
            binding.btnFavoriteDetails.isChecked = isFavorite
        })
        binding.btnFavoriteDetails.setOnClickListener{
            detailsViewModel.toggleFavorite(movieId)
        }
    }

    private fun showDetails( movie: MovieDetails){
        binding.apply {
            tvMovieTitle.text = movie.title
            tvMovieRating.text = movie.score.toString()
            tvMovieMembers.text = movie.members.toString()
            tvMovieAired.text = SimpleDateFormat("yyyy").format(movie.getAired()!!.from!!)
            tvMovieRated.text = movie.rating
            tvMovieSynopsis.text = movie.synopsis
            Glide.with(this@DetailsActivity).load(movie.imageUrl).into(ivImage)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }
}