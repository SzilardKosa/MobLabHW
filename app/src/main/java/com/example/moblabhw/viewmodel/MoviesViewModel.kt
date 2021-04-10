package com.example.moblabhw.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.model.Movie
import com.example.moblabhw.repository.MoviesRepository

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : MoviesRepository = MoviesRepository()
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