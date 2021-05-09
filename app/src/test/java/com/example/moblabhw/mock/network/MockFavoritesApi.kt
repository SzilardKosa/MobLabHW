package com.example.moblabhw.mock.network

import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.LocalMovie
import com.example.moblabhw.model.network.LocalMovies
import com.example.moblabhw.model.network.Movie
import com.example.moblabhw.model.network.Movies
import com.example.moblabhw.network.FavoritesApi
import java.util.*

class MockFavoritesApi : FavoritesApi {
    var movies = listOf(
        LocalMovie(
            isFavorite = true,
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
        LocalMovie(
            isFavorite = true,
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
        LocalMovie(
            isFavorite = true,
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


    override suspend fun getFavorites(): LocalMovies {
        var favorites = movies.filter { m -> m.isFavorite }
        var result = LocalMovies()
        for (favorite in favorites) {
            result.add(favorite)
        }
        return result
    }

    override suspend fun newFavorite(movie: MovieModel) {
        var newMovies = mutableListOf<LocalMovie>()
        movies.forEach { m ->
            if (m.malId == movie.malId) {
                m.isFavorite = true
            }
            newMovies.add(m)
        }
        movies = newMovies
    }

    override suspend fun updateFavorite(id: Int, movie: MovieModel) {
        var newMovies = mutableListOf<LocalMovie>()
        movies.forEach { m ->
            if (m.malId == movie.malId) {
                m.isFavorite = false
            }
            newMovies.add(m)
        }
        movies = newMovies

    }

}