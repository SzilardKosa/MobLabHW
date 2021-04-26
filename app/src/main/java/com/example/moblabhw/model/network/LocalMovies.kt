package com.example.moblabhw.model.network

import io.swagger.annotations.ApiModel;
import java.util.*

/**
 * Movie model in the database (Movie model with is_favorite field)
 */
@ApiModel(description = "Movie model in the database (Movie model with is_favorite field)")
class LocalMovies : ArrayList<LocalMovie?>() {
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val localMovies = o as LocalMovies
        return true
    }

    override fun hashCode(): Int {
        return Objects.hash()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class LocalMovies {\n")
        sb.append("    ").append(toIndentedString(super.toString())).append("\n")
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