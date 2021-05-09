package com.example.moblabhw.mock.db

import androidx.lifecycle.LiveData
import com.example.moblabhw.database.MoviesDAO
import com.example.moblabhw.model.db.MovieCacheEntity
import com.example.moblabhw.model.network.Movie
import com.example.moblabhw.model.network.Movies
import java.util.*

class MockMoviesDAO : MoviesDAO {
    var movies: MutableList<MovieCacheEntity> = mutableListOf()

    init {
        movies = mutableListOf<MovieCacheEntity>(
            MovieCacheEntity(
                malId = 0,
                title = "Test 1",
                score = 7.3f,
                members = 123,
                imageUrl = "url",
                url = "url",
                airing = false,
                episodes = 1,
                rated = "R",
                type = "Movie",
                synopsis = "Blablabal",
                startDate = Date("1/1/2020"),
                endDate = Date("1/1/2020"),
                isFavorite = false
            ),
            MovieCacheEntity(
                malId = 1,
                title = "Test 2",
                score = 7.3f,
                members = 123,
                imageUrl = "url",
                url = "url",
                airing = false,
                episodes = 1,
                rated = "R",
                type = "Movie",
                synopsis = "Blablabal",
                startDate = Date("1/1/2020"),
                endDate = Date("1/1/2020"),
                isFavorite = false
            ),
            MovieCacheEntity(
                malId = 3,
                title = "Test 3",
                score = 7.3f,
                members = 123,
                imageUrl = "url",
                url = "url",
                airing = false,
                episodes = 1,
                rated = "R",
                type = "Movie",
                synopsis = "Blablabal",
                startDate = Date("1/1/2020"),
                endDate = Date("1/1/2020"),
                isFavorite = false
            )
        )
    }

    override fun getAllMovies(): LiveData<List<MovieCacheEntity>> {
        TODO("Not yet implemented")
    }

    override fun getAllFavorites(): LiveData<List<MovieCacheEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovie(id: Int): MovieCacheEntity {
        return movies.filter { movie -> movie.malId == id }[0]
    }

    override suspend fun getCache(): List<MovieCacheEntity> {
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
        var newMovies: MutableList<MovieCacheEntity> = mutableListOf()
        movies.forEach { m ->
            if(m.malId == movie.malId){
                m.isFavorite = movie.isFavorite
            }
            newMovies.add(m)
        }
        movies = newMovies
    }
}