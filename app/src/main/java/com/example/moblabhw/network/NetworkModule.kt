package com.example.moblabhw.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // https://stackoverflow.com/questions/65266636/is-applicationcomponent-deprecated
object NetworkModule {

    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(MoviesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideFavoritesApi(): FavoritesApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(FavoritesApi::class.java)
    }
}