package com.example.moblabhw.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.model.Movie
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : FavoritesRepository = FavoritesRepository()
    val allFavorites: MutableLiveData<List<Movie>>

    init {
        allFavorites = repository.allFavorites
    }

    fun getFavorites() {
        repository.getFavorites()
    }

    fun delete(movie: Movie) {
        repository.delete(movie)
    }

    fun toggleFavorite(movie: Movie) {
        repository.toggleFavorite(movie)
    }
}