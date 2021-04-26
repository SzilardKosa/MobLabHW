package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal
import java.util.*

/**
 * Movie model in the list response from Jikan API
 */
@ApiModel(description = "Movie model in the list response from Jikan API")
data class Movie (
    @SerializedName("mal_id")
    var malId: Int,

    @SerializedName("url")
    var url: String,

    @SerializedName("image_url")
    var imageUrl: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("airing")
    var airing: Boolean,

    @SerializedName("synopsis")
    var synopsis: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("episodes")
    var episodes: Int,

    @SerializedName("score")
    var score: Float,

    @SerializedName("start_date")
    var startDate: Date,

    @SerializedName("end_date")
    var endDate: Date,

    @SerializedName("members")
    var members: Int,

    @SerializedName("rated")
    var rated: String
)