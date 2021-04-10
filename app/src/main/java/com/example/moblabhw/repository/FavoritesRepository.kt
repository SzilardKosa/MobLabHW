package com.example.moblabhw.repository

import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.model.Movie

class FavoritesRepository {
    val allFavorites: MutableLiveData<List<Movie>> = MutableLiveData(listOf(Movie(1, "Movie 1")))

    fun getFavorites() {
        // TODO: refresh favorites list from DB
    }

    fun delete(movie: Movie) {
        // TODO: delete movie from DB
    }

    fun toggleFavorite(movie: Movie) {
        // TODO: add to or remove from favorites
    }
}