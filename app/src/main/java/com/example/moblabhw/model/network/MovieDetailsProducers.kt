package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
class MovieDetailsProducers {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("mal_id")
    var malId: Int? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("url")
    var url: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val movieDetailsProducers = o as MovieDetailsProducers
        return name == movieDetailsProducers.name &&
                malId == movieDetailsProducers.malId &&
                type == movieDetailsProducers.type &&
                url == movieDetailsProducers.url
    }

    override fun hashCode(): Int {
        return Objects.hash(name, malId, type, url)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class MovieDetailsProducers {\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    malId: ").append(toIndentedString(malId)).append("\n")
        sb.append("    type: ").append(toIndentedString(type)).append("\n")
        sb.append("    url: ").append(toIndentedString(url)).append("\n")
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