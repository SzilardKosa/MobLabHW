package com.example.moblabhw.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moblabhw.model.Movie
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel()  {
    val allMovies: MutableLiveData<List<Movie>>

    init {
        allMovies = repository.allMovies
    }

    fun getMovies() {
        repository.getMovies()
    }

    fun delete(movie:Movie) {
        repository.delete(movie)
    }

    fun toggleFavorite(movie:Movie) {
        repository.toggleFavorite(movie)
    }
}