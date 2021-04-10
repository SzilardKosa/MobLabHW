package com.example.moblabhw.repository

import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.model.Movie
import com.example.moblabhw.model.MovieDetails

class DetailsRepository {
    val details: MutableLiveData<MovieDetails> = MutableLiveData(MovieDetails(1, "Movie 1", "description"))

    fun getDetails() {
        // TODO: refresh movie from the network
    }

    fun toggleFavorite(movieDetails: MovieDetails) {
        // TODO: add to or remove from favorites
    }
}