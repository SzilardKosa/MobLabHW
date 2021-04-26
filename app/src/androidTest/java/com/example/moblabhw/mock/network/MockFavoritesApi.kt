package com.example.moblabhw.mock.network

import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.LocalMovies
import com.example.moblabhw.network.FavoritesApi

class MockFavoritesApi : FavoritesApi {
    override suspend fun getFavorites(): LocalMovies {
        TODO("Not yet implemented")
    }

    override suspend fun newFavorite(movie: MovieModel): Void {
        TODO("Not yet implemented")
    }

    override suspend fun updateFavorite(id: Int, movie: MovieModel): Void {
        TODO("Not yet implemented")
    }

}