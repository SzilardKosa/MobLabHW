package com.example.moblabhw.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moblabhw.model.Movie
import com.example.moblabhw.model.MovieDetails
import com.example.moblabhw.repository.DetailsRepository
import com.example.moblabhw.repository.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: DetailsRepository
) : ViewModel() {
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