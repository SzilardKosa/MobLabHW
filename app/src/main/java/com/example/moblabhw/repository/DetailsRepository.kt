package com.example.moblabhw.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moblabhw.database.CacheMapper
import com.example.moblabhw.database.MoviesDAO
import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.network.FavoritesApi
import com.example.moblabhw.network.MoviesApi
import com.example.moblabhw.util.DataState

class DetailsRepository
constructor(
    private val moviesDAO: MoviesDAO,
    private val moviesApi: MoviesApi,
    private val cacheMapper: CacheMapper,
    private val favoritesApi: FavoritesApi
) {
    val movieDetails: MutableLiveData<DataState<MovieDetails>> = MutableLiveData()
    val isFavorite: MutableLiveData<Boolean> = MutableLiveData(false)


    suspend fun getDetails(movieId: Int) {
        // Network: get movie from [Jikan API] by id
        movieDetails.postValue(DataState.Loading)
        try{
            val networkMovie = moviesApi.getMovie(movieId)
            Log.d("Reponse", networkMovie.toString())
            val cachedMovie = moviesDAO.getMovie(networkMovie.malId!!)
            isFavorite.postValue(cachedMovie.isFavorite)
            movieDetails.postValue(DataState.Success(networkMovie))
        }catch (e: Exception){
            movieDetails.postValue(DataState.Error(e))
        }
    }

    suspend fun toggleFavorite(id: Int) {
        // (Network: post or put)
        // DB: update movie in db
        try{
            val movie = cacheMapper.mapFromEntity(moviesDAO.getMovie(id))
            movie.isFavorite = !movie.isFavorite
            if (movie.isFavorite) {
                // Post new favorite
                moviesDAO.updateMovie(cacheMapper.mapToEntity(movie))
                isFavorite.postValue(true)
                favoritesApi.newFavorite(movie)
            } else {
                // Put update, remove from favorite
                moviesDAO.updateMovie(cacheMapper.mapToEntity(movie))
                isFavorite.postValue(false)
                favoritesApi.updateFavorite(movie.malId, movie)
            }
        }catch (e: Exception){
            movieDetails.postValue(DataState.Error(e))
        }
    }
}