package com.example.moblabhw.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // https://stackoverflow.com/questions/65266636/is-applicationcomponent-deprecated
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDb(@ApplicationContext context: Context): MovieDatabase {
        return Room
                .databaseBuilder(
                        context,
                        MovieDatabase::class.java,
                        MovieDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideMoviesDAO(movieDatabase: MovieDatabase): MoviesDAO {
        return movieDatabase.moviesDAO()
    }
}