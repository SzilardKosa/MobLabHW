package com.example.moblabhw.mock.network

import com.example.moblabhw.network.FavoritesApi
import com.example.moblabhw.network.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // https://stackoverflow.com/questions/65266636/is-applicationcomponent-deprecated
object MockNetworkModule {

    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesApi = MockMoviesApi()

    @Singleton
    @Provides
    fun provideFavoritesApi(): FavoritesApi = MockFavoritesApi()
}