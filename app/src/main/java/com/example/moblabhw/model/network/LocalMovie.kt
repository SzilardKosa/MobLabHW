package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import java.math.BigDecimal
import java.util.*

/**
 * Movie model in the database (Movie model with is_favorite field)
 */
@ApiModel(description = "Movie model in the database (Movie model with is_favorite field)")
data class LocalMovie (
    @SerializedName("end_date")
    var endDate: Date,

    @SerializedName("is_favorite")
    var isFavorite: Boolean,

    @SerializedName("image_url")
    var imageUrl: String,

    @SerializedName("mal_id")
    var malId: Int,

    @SerializedName("synopsis")
    var synopsis: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("url")
    var url: String,

    @SerializedName("rated")
    var rated: String,

    @SerializedName("score")
    var score: Float,

    @SerializedName("members")
    var members: Int,

    @SerializedName("airing")
    var airing: Boolean,

    @SerializedName("episodes")
    var episodes: Int,

    @SerializedName("start_date")
    var startDate: Date
)