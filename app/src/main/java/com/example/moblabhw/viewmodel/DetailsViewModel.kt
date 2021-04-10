package com.example.moblabhw.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.model.Movie
import com.example.moblabhw.model.MovieDetails
import com.example.moblabhw.repository.DetailsRepository
import com.example.moblabhw.repository.FavoritesRepository

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : DetailsRepository = DetailsRepository()
    val details: MutableLiveData<MovieDetails>

    init {
        details = repository.details
    }

    fun getDetails() {
        repository.getDetails()
    }

    fun toggleFavorite(movieDetails: MovieDetails) {
        repository.toggleFavorite(movieDetails)
    }

}