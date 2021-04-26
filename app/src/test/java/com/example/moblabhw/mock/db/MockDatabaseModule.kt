package com.example.moblabhw.mock.db

import com.example.moblabhw.database.MoviesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // https://stackoverflow.com/questions/65266636/is-applicationcomponent-deprecated
object MockDatabaseModule {

    @Singleton
    @Provides
    fun provideMoviesDAO(): MoviesDAO = MockMoviesDAO()
}