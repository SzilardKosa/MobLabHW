package com.example.moblabhw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.repository.DetailsRepository
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository
import com.example.moblabhw.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: DetailsRepository,
) : ViewModel() {
    val movieDetails: LiveData<DataState<MovieDetails>> = repository.movieDetails
    val isFavorite: LiveData<Boolean> = repository.isFavorite

    fun getDetails(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.getDetails(id)
    }

    fun toggleFavorite(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.toggleFavorite(id)
    }

}