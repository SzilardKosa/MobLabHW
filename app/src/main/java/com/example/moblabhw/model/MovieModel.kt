package com.example.moblabhw.model

import java.util.*

data class MovieModel (
    var malId: Int,
    var endDate: Date,
    var isFavorite: Boolean,
    var imageUrl: String,
    var synopsis: String,
    var title: String,
    var type: String,
    var url: String,
    var rated: String,
    var score: Float,
    var members: Int,
    var airing: Boolean,
    var episodes: Int,
    var startDate: Date
)