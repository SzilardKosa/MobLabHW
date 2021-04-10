package com.example.moblabhw.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // https://stackoverflow.com/questions/65266636/is-applicationcomponent-deprecated
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(): MoviesRepository {
        return MoviesRepository()
    }

    @Singleton
    @Provides
    fun provideFavoritesRepository(): FavoritesRepository {
        return FavoritesRepository()
    }

    @Singleton
    @Provides
    fun provideDetailsRepository(): DetailsRepository {
        return DetailsRepository()
    }
}