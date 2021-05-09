package com.example.moblabhw.mock.network

import com.example.moblabhw.model.network.Movie
import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.model.network.Movies
import com.example.moblabhw.network.MoviesApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class MockMoviesApi: MoviesApi {
    var movies = Movies()

    override suspend fun getMovie(id: Int): MovieDetails {
        InitMovies()
//        var movie = movies.results.filter { movie -> movie.malId == id }[0]
        var movie = movies.results[0]
        var details = MovieDetails()
        details.malId = movie.malId
        details.title = movie.title
        details.score = movie.score
        details.isFavorite =
        return  details
    }

    override suspend fun deleteMovie(id: Int) {
        movies.results = movies.results.filter { movie -> movie.malId != id }
    }

    override suspend fun searchMovies(
        searchType: String,
        q: String?,
        type: String?,
        producer: Int?,
        orderBy: String?,
        sort: String?
    ): Movies {
        InitMovies()
        return  movies
    }

    private fun InitMovies(){
        movies.results = listOf(
            Movie(
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
                endDate = Date("1/1/2020")
            ),
            Movie(
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
                endDate = Date("1/1/2020")
            ),
            Movie(
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
                endDate = Date("1/1/2020")
            )
        )
    }
}