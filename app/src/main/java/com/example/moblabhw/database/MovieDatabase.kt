package com.example.moblabhw.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moblabhw.model.db.MovieCacheEntity

@Database(entities = [MovieCacheEntity::class ], version = 1)
@TypeConverters(Converters::class)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun moviesDAO(): MoviesDAO

    companion object{
        val DATABASE_NAME: String = "movies_db"
    }

}