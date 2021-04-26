package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import java.util.*

/**
 * Movie list response from Jikan API
 */
@ApiModel(description = "Movie list response from Jikan API")
class Movies {
    @SerializedName("request_hash")
    var requestHash: String? = null

    @SerializedName("request_cached")
    var requestCached: Boolean? = null

    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int? = null

    @SerializedName("results")
    var results: List<Movie> =
        ArrayList()

    @SerializedName("last_page")
    var lastPage: Int? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val movies = o as Movies
        return requestHash == movies.requestHash &&
                requestCached == movies.requestCached &&
                requestCacheExpiry == movies.requestCacheExpiry &&
                results == movies.results &&
                lastPage == movies.lastPage
    }

    override fun hashCode(): Int {
        return Objects.hash(
            requestHash,
            requestCached,
            requestCacheExpiry,
            results,
            lastPage
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Movies {\n")
        sb.append("    requestHash: ").append(toIndentedString(requestHash)).append("\n")
        sb.append("    requestCached: ").append(toIndentedString(requestCached)).append("\n")
        sb.append("    requestCacheExpiry: ").append(toIndentedString(requestCacheExpiry))
            .append("\n")
        sb.append("    results: ").append(toIndentedString(results)).append("\n")
        sb.append("    lastPage: ").append(toIndentedString(lastPage)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}