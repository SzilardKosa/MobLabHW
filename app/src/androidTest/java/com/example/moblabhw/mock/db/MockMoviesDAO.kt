package com.example.moblabhw.mock.db

import androidx.lifecycle.LiveData
import com.example.moblabhw.database.MoviesDAO
import com.example.moblabhw.model.db.MovieCacheEntity

class MockMoviesDAO : MoviesDAO {
    override fun getAllMovies(): LiveData<List<MovieCacheEntity>> {
        TODO("Not yet implemented")
    }

    override fun getAllFavorites(): LiveData<List<MovieCacheEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovie(id: Int): MovieCacheEntity {
        TODO("Not yet implemented")
    }

    override suspend fun insertMovie(movie: MovieCacheEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertMovies(vararg movie: MovieCacheEntity): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun insertMoviesList(movies: List<MovieCacheEntity>): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovie(movie: MovieCacheEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllMovies() {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovie(movie: MovieCacheEntity) {
        TODO("Not yet implemented")
    }
}