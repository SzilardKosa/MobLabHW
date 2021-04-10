package com.example.moblabhw.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moblabhw.model.Movie
import com.example.moblabhw.repository.DetailsRepository
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: FavoritesRepository
) : ViewModel() {
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