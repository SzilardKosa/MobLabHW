package com.example.moblabhw.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moblabhw.model.db.MovieCacheEntity

@Dao
interface MoviesDAO {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<MovieCacheEntity>>

    @Query("SELECT * FROM movies WHERE is_favorite=1")
    fun getAllFavorites(): LiveData<List<MovieCacheEntity>>

    @Query("SELECT * FROM movies WHERE malId=:id")
    suspend fun getMovie(id: Int): MovieCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieCacheEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(vararg movie: MovieCacheEntity): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesList(movies: List<MovieCacheEntity>): List<Long>

    @Delete
    suspend fun deleteMovie(movie: MovieCacheEntity)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()

    @Update
    suspend fun updateMovie(movie: MovieCacheEntity)
}