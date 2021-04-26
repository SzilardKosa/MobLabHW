package com.example.moblabhw.network

import com.example.moblabhw.model.network.Movie
import com.example.moblabhw.model.network.MovieDetails
import com.example.moblabhw.model.network.Movies
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    /**
     * Gets anime from Jikan api
     * It can be used to get Studio Ghibli movie details.
     * @param id MAL ID of the anime
     * @return Call<MovieDetails>
    </MovieDetails> */
    @GET("anime/{id}")
    suspend fun getMovie(
        @Path("id") id: Int
    ): MovieDetails

    /**
     * Delete anime from from local db by id
     * It can be used to delete a movie from the list.
     * @param id MAL ID of the anime
     * @return Call<Void>
    </Void> */
    @DELETE("anime/{id}")
    suspend fun deleteMovie(
        @Path("id") id: Int
    ): Void

    /**
     * Gets search result from Jikan api
     * It can be used to get all Studio Ghibli movies.
     * @param searchType Specify where to search
     * @param q For UTF8 characters, percentage encoded and queries including back slashes (leave empty, to get all)
     * @param type Filter type of results
     * @param producer MAL ID of the producer (21 - Studio Ghibli)
     * @param orderBy Order results with respect to a property (these values are for anime enities)
     * @param sort Sort order_by (Default is descending)
     * @return Call<Movies>
    </Movies> */
    @GET("search/{searchType}")
    suspend fun searchMovies(
        @Path("searchType") searchType: String,
        @Query("q") q: String?,
        @Query("type") type: String?,
        @Query("producer") producer: Int?,
        @Query("order_by") orderBy: String?,
        @Query("sort") sort: String?
    ): Movies
}