package com.example.moblabhw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository
import com.example.moblabhw.util.DataState
import com.example.moblabhw.util.FetchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val favoritesRepository: FavoritesRepository
) : ViewModel()  {
    val allMovies: LiveData<List<MovieModel>> = moviesRepository.allMovies
    val fetchState: LiveData<FetchState<Nothing>> = moviesRepository.fetchState

    fun getMovies() = viewModelScope.launch(Dispatchers.IO) {
        moviesRepository.getMovies()
    }

    fun delete(movie:MovieModel) = viewModelScope.launch(Dispatchers.IO) {
        moviesRepository.delete(movie)
    }

    fun toggleFavorite(movie:MovieModel) = viewModelScope.launch(Dispatchers.IO) {
        favoritesRepository.toggleFavorite(movie)
    }
}