package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import java.util.*

@ApiModel(description = "")
class MovieDetailsAiredProp {
    @SerializedName("from")
    private var from: MovieDetailsAiredPropFrom? = null

    @SerializedName("to")
    private var to: MovieDetailsAiredPropTo? = null

    fun getFrom(): MovieDetailsAiredPropFrom? {
        return from
    }

    fun setFrom(from: MovieDetailsAiredPropFrom?) {
        this.from = from
    }

    fun getTo(): MovieDetailsAiredPropTo? {
        return to
    }

    fun setTo(to: MovieDetailsAiredPropTo?) {
        this.to = to
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val movieDetailsAiredProp = o as MovieDetailsAiredProp
        return from == movieDetailsAiredProp.from &&
                to == movieDetailsAiredProp.to
    }

    override fun hashCode(): Int {
        return Objects.hash(from, to)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class MovieDetailsAiredProp {\n")
        sb.append("    from: ").append(toIndentedString(from)).append("\n")
        sb.append("    to: ").append(toIndentedString(to)).append("\n")
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