package com.example.moblabhw.mock.network

import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.model.network.Movies
import com.example.moblabhw.network.MoviesApi

class MockMoviesApi: MoviesApi {
    override suspend fun getMovie(id: Int): MovieDetails {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovie(id: Int): Void {
        TODO("Not yet implemented")
    }

    override suspend fun searchMovies(
        searchType: String,
        q: String?,
        type: String?,
        producer: Int?,
        orderBy: String?,
        sort: String?
    ): Movies {
        TODO("Not yet implemented")
    }
}