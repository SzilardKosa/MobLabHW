package com.example.moblabhw.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.moblabhw.database.CacheMapper
import com.example.moblabhw.database.MoviesDAO
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.network.FavoritesApi
import com.example.moblabhw.network.MoviesApi
import com.example.moblabhw.network.NetworkMapper
import com.example.moblabhw.util.DataState
import com.example.moblabhw.util.FetchState

class FavoritesRepository
constructor(
    private val moviesDAO: MoviesDAO,
    private val favoritesApi: FavoritesApi,
    private val cacheMapper: CacheMapper
){
    val fetchState: MutableLiveData<FetchState<Nothing>> = MutableLiveData()
    val allFavorites: LiveData<List<MovieModel>> = Transformations.map(moviesDAO.getAllFavorites())
    { cachedMovies -> cacheMapper.mapFromEntityList(cachedMovies) }

    suspend fun getFavorites() {
        // (Network: get favorites)
        // DB: get favorites
        fetchState.postValue(FetchState.Loading)
        try{
            // This API call makes no sense with the current setup,
            // because we get the result from the local DB!!!
            // val networkMovies = favoritesApi.getFavorites()
            fetchState.postValue(FetchState.Success)
        }catch (e: Exception){
            fetchState.postValue(FetchState.Error(e))
        }
    }

    suspend fun toggleFavorite(movie: MovieModel) {
        // (Network: post or put)
        // DB: update movie in db
        try{
            movie.isFavorite = !movie.isFavorite
            if (movie.isFavorite) {
                // Post new favorite
                moviesDAO.updateMovie(cacheMapper.mapToEntity(movie))
                favoritesApi.newFavorite(movie)
            } else {
                // Put update, remove from favorite
                moviesDAO.updateMovie(cacheMapper.mapToEntity(movie))
                favoritesApi.updateFavorite(movie.malId, movie)
            }
        }catch (e: Exception){
            Log.d("Error", e.message.toString())
        }
    }
}