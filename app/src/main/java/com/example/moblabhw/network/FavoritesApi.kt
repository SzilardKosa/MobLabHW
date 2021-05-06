package com.example.moblabhw.network

import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.LocalMovie
import com.example.moblabhw.model.network.LocalMovies
import retrofit2.Call
import retrofit2.http.*

interface FavoritesApi {
    /**
     * Gets all favorite movies
     * It can be used to get all favorite Studio Ghibli movies.
     * @return Call<LocalMovies>
    </LocalMovies> */
    @GET("favorites")
    suspend fun getFavorites(): LocalMovies

    /**
     * Add to favorite movies
     * It can be used to add a movie to the favorite Studio Ghibli movies.
     * @param movie New favorite movie
     * @return Call<Void>
    </Void> */
    @POST("favorites")
    suspend fun newFavorite(
        @Body movie: MovieModel
    )

    /**
     * Delete anime from favorite list by id
     * It can be used to delete a movie from the favorite list.
     * @param id MAL ID of the anime
     * @param movie Movie to remove
     * @return Call<Void>
    </Void> */
    @PUT("favorites/{id}")
    suspend fun updateFavorite(
        @Path("id") id: Int, @Body movie: MovieModel
    )
}