package com.example.moblabhw.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.moblabhw.database.CacheMapper
import com.example.moblabhw.database.MoviesDAO
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.network.MoviesApi
import com.example.moblabhw.network.NetworkMapper
import com.example.moblabhw.util.FetchState

class MoviesRepository
constructor(
        private val moviesDAO: MoviesDAO,
        private val moviesApi: MoviesApi,
        private val cacheMapper: CacheMapper,
        private val networkMapper: NetworkMapper
){

    val fetchState: MutableLiveData<FetchState<Nothing>> = MutableLiveData()
    val allMovies: LiveData<List<MovieModel>> = Transformations.map(moviesDAO.getAllMovies())
            { cachedMovies -> cacheMapper.mapFromEntityList(cachedMovies) }


    suspend fun getMovies(){
        // Network: get movies from [Jikan API]
        // DB: save results with is_favorite = false
        fetchState.postValue(FetchState.Loading)
        try{
            // Check if the movies are cached already
            val movies = moviesDAO.getCache()
            if (movies.size < 20){
                val networkMovies = moviesApi.searchMovies(
                                                "anime",
                                                "",
                                                "movie",
                                                21,
                                                "start_date",
                                                "asc")
                Log.d("Reponse", networkMovies.toString())
                val movies = networkMapper.mapFromEntityList(networkMovies.results)
                moviesDAO.insertMoviesList(cacheMapper.mapToEntityList(movies))
            }
            fetchState.postValue(FetchState.Success)
        }catch (e: Exception){
            fetchState.postValue(FetchState.Error(e))
        }
    }

    suspend fun delete(movie: MovieModel) {
        // (Network: delete movie by id)
        // DB: delete movie from db
        try{
            moviesDAO.deleteMovie(cacheMapper.mapToEntity(movie))
            moviesApi.deleteMovie(movie.malId)
        }catch (e: Exception){
            Log.d("Error", e.message.toString())
        }
    }
}