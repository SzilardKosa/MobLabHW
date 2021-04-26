package com.example.moblabhw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository
import com.example.moblabhw.util.FetchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {
    val allFavorites: LiveData<List<MovieModel>> = favoritesRepository.allFavorites
    val fetchState: LiveData<FetchState<Nothing>> = favoritesRepository.fetchState

    fun getFavorites() = viewModelScope.launch(Dispatchers.IO) {
        favoritesRepository.getFavorites()
    }

    fun delete(movie:MovieModel) = viewModelScope.launch(Dispatchers.IO) {
        moviesRepository.delete(movie)
    }

    fun toggleFavorite(movie:MovieModel) = viewModelScope.launch(Dispatchers.IO) {
        favoritesRepository.toggleFavorite(movie)
    }
}