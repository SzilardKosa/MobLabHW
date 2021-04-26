package com.example.moblabhw.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "movies")
data class MovieCacheEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "malId")
        var malId: Int,

        @ColumnInfo(name="end_date")
        var endDate: Date,

        @ColumnInfo(name="is_favorite")
        var isFavorite: Boolean,

        @ColumnInfo(name="image_url")
        var imageUrl: String,

        @ColumnInfo(name="synopsis")
        var synopsis: String,

        @ColumnInfo(name="title")
        var title: String,

        @ColumnInfo(name="type")
        var type: String,

        @ColumnInfo(name="url")
        var url: String,

        @ColumnInfo(name="rated")
        var rated: String,

        @ColumnInfo(name="score")
        var score: Float,

        @ColumnInfo(name="members")
        var members: Int,

        @ColumnInfo(name="airing")
        var airing: Boolean,

        @ColumnInfo(name="episodes")
        var episodes: Int,

        @ColumnInfo(name="start_date")
        var startDate: Date
)

