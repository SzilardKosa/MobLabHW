package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import java.util.*

@ApiModel(description = "")
class MovieDetailsAired {
    @SerializedName("string")
    var string: String? = null

    @SerializedName("prop")
    private var prop: MovieDetailsAiredProp? = null

    @SerializedName("from")
    var from: Date? = null

    @SerializedName("to")
    var to: String? = null

    fun getProp(): MovieDetailsAiredProp? {
        return prop
    }

    fun setProp(prop: MovieDetailsAiredProp?) {
        this.prop = prop
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val movieDetailsAired = o as MovieDetailsAired
        return string == movieDetailsAired.string &&
                prop == movieDetailsAired.prop &&
                from == movieDetailsAired.from &&
                to == movieDetailsAired.to
    }

    override fun hashCode(): Int {
        return Objects.hash(string, prop, from, to)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class MovieDetailsAired {\n")
        sb.append("    string: ").append(toIndentedString(string)).append("\n")
        sb.append("    prop: ").append(toIndentedString(prop)).append("\n")
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