package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import java.util.*

@ApiModel(description = "")
class MovieDetailsAiredPropTo {
    @SerializedName("month")
    var month: Int? = null

    @SerializedName("year")
    var year: Int? = null

    @SerializedName("day")
    var day: Int? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val movieDetailsAiredPropTo = o as MovieDetailsAiredPropTo
        return month == movieDetailsAiredPropTo.month &&
                year == movieDetailsAiredPropTo.year &&
                day == movieDetailsAiredPropTo.day
    }

    override fun hashCode(): Int {
        return Objects.hash(month, year, day)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class MovieDetailsAiredPropTo {\n")
        sb.append("    month: ").append(toIndentedString(month)).append("\n")
        sb.append("    year: ").append(toIndentedString(year)).append("\n")
        sb.append("    day: ").append(toIndentedString(day)).append("\n")
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