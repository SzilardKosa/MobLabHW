package com.example.moblabhw.repository

import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.model.Movie

class MoviesRepository {
    val allMovies: MutableLiveData<List<Movie>> = MutableLiveData(listOf(Movie(1, "Movie 1"), Movie(2, "Movie 2")))

    fun getMovies() {
        // TODO: refresh movies from the network
    }

    fun delete(movie:Movie) {
        // TODO: delete movie from DB
    }

    fun toggleFavorite(movie:Movie) {
        // TODO: add to or remove from favorites
    }
}