package com.example.moblabhw.repository

import com.example.moblabhw.database.CacheMapper
import com.example.moblabhw.database.MoviesDAO
import com.example.moblabhw.network.FavoritesApi
import com.example.moblabhw.network.MoviesApi
import com.example.moblabhw.network.NetworkMapper
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
    fun provideMoviesRepository(
            moviesDAO: MoviesDAO,
            moviesApi: MoviesApi,
            cacheMapper: CacheMapper,
            networkMapper: NetworkMapper
    ): MoviesRepository {
        return MoviesRepository(moviesDAO, moviesApi, cacheMapper, networkMapper)
    }

    @Singleton
    @Provides
    fun provideDetailsRepository(
            moviesDAO: MoviesDAO,
            moviesApi: MoviesApi,
            cacheMapper: CacheMapper,
            favoritesApi: FavoritesApi
    ): DetailsRepository {
        return DetailsRepository(moviesDAO, moviesApi, cacheMapper, favoritesApi)
    }

    @Singleton
    @Provides
    fun provideFavoritesRepository(
            moviesDAO: MoviesDAO,
            favoritesApi: FavoritesApi,
            cacheMapper: CacheMapper
    ): FavoritesRepository {
        return FavoritesRepository(moviesDAO, favoritesApi, cacheMapper)
    }
}