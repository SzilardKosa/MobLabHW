package com.example.moblabhw.model.network

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import java.util.*

/**
 * Movie details response from Jikan API
 */
@ApiModel(description = "Movie details response from Jikan API")
class MovieDetails {
    @SerializedName("request_hash")
    var requestHash: String? = null

    @SerializedName("is_favorite")
    var isFavorite: Boolean? = null

    @SerializedName("request_cached")
    var requestCached: Boolean? = null

    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int? = null

    @SerializedName("mal_id")
    var malId: Int? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("image_url")
    var imageUrl: String? = null

    @SerializedName("trailer_url")
    var trailerUrl: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("title_english")
    var titleEnglish: String? = null

    @SerializedName("title_japanese")
    var titleJapanese: String? = null

    @SerializedName("title_synonyms")
    var titleSynonyms: List<String> =
        ArrayList()

    @SerializedName("type")
    var type: String? = null

    @SerializedName("source")
    var source: String? = null

    @SerializedName("episodes")
    var episodes: Int? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("airing")
    var airing: Boolean? = null

    @SerializedName("aired")
    private var aired: MovieDetailsAired? = null

    @SerializedName("duration")
    var duration: String? = null

    @SerializedName("rating")
    var rating: String? = null

    @SerializedName("score")
    var score: Float? = null

    @SerializedName("scored_by")
    var scoredBy: Int? = null

    @SerializedName("rank")
    var rank: Int? = null

    @SerializedName("popularity")
    var popularity: Int? = null

    @SerializedName("members")
    var members: Int? = null

    @SerializedName("favorites")
    var favorites: Int? = null

    @SerializedName("synopsis")
    var synopsis: String? = null

    @SerializedName("background")
    var background: String? = null

    @SerializedName("premiered")
    var premiered: String? = null

    @SerializedName("broadcast")
    var broadcast: String? = null

    @SerializedName("producers")
    private var producers: List<MovieDetailsProducers> =
        ArrayList<MovieDetailsProducers>()

    @SerializedName("licensors")
    private var licensors: List<MovieDetailsProducers> =
        ArrayList<MovieDetailsProducers>()

    @SerializedName("studios")
    private var studios: List<MovieDetailsProducers> =
        ArrayList<MovieDetailsProducers>()

    @SerializedName("genres")
    private var genres: List<MovieDetailsProducers> =
        ArrayList<MovieDetailsProducers>()

    @SerializedName("opening_themes")
    var openingThemes: List<String> =
        ArrayList()

    @SerializedName("ending_themes")
    var endingThemes: List<String> =
        ArrayList()

    fun getAired(): MovieDetailsAired? {
        return aired
    }

    fun setAired(aired: MovieDetailsAired?) {
        this.aired = aired
    }

    fun getProducers(): List<MovieDetailsProducers> {
        return producers
    }

    fun setProducers(producers: List<MovieDetailsProducers>) {
        this.producers = producers
    }

    fun getLicensors(): List<MovieDetailsProducers> {
        return licensors
    }

    fun setLicensors(licensors: List<MovieDetailsProducers>) {
        this.licensors = licensors
    }

    fun getStudios(): List<MovieDetailsProducers> {
        return studios
    }

    fun setStudios(studios: List<MovieDetailsProducers>) {
        this.studios = studios
    }

    fun getGenres(): List<MovieDetailsProducers> {
        return genres
    }

    fun setGenres(genres: List<MovieDetailsProducers>) {
        this.genres = genres
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val movieDetails =
            o as MovieDetails
        return requestHash == movieDetails.requestHash &&
                requestCached == movieDetails.requestCached &&
                requestCacheExpiry == movieDetails.requestCacheExpiry &&
                malId == movieDetails.malId &&
                url == movieDetails.url &&
                imageUrl == movieDetails.imageUrl &&
                trailerUrl == movieDetails.trailerUrl &&
                title == movieDetails.title &&
                titleEnglish == movieDetails.titleEnglish &&
                titleJapanese == movieDetails.titleJapanese &&
                titleSynonyms == movieDetails.titleSynonyms &&
                type == movieDetails.type &&
                source == movieDetails.source &&
                episodes == movieDetails.episodes &&
                status == movieDetails.status &&
                airing == movieDetails.airing &&
                aired == movieDetails.aired &&
                duration == movieDetails.duration &&
                rating == movieDetails.rating &&
                score == movieDetails.score &&
                scoredBy == movieDetails.scoredBy &&
                rank == movieDetails.rank &&
                popularity == movieDetails.popularity &&
                members == movieDetails.members &&
                favorites == movieDetails.favorites &&
                synopsis == movieDetails.synopsis &&
                background == movieDetails.background &&
                premiered == movieDetails.premiered &&
                broadcast == movieDetails.broadcast &&
                producers == movieDetails.producers &&
                licensors == movieDetails.licensors &&
                studios == movieDetails.studios &&
                genres == movieDetails.genres &&
                openingThemes == movieDetails.openingThemes &&
                endingThemes == movieDetails.endingThemes
    }

    override fun hashCode(): Int {
        return Objects.hash(
            requestHash,
            requestCached,
            requestCacheExpiry,
            malId,
            url,
            imageUrl,
            trailerUrl,
            title,
            titleEnglish,
            titleJapanese,
            titleSynonyms,
            type,
            source,
            episodes,
            status,
            airing,
            aired,
            duration,
            rating,
            score,
            scoredBy,
            rank,
            popularity,
            members,
            favorites,
            synopsis,
            background,
            premiered,
            broadcast,
            producers,
            licensors,
            studios,
            genres,
            openingThemes,
            endingThemes
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class MovieDetails {\n")
        sb.append("    requestHash: ").append(toIndentedString(requestHash)).append("\n")
        sb.append("    requestCached: ").append(toIndentedString(requestCached)).append("\n")
        sb.append("    requestCacheExpiry: ").append(toIndentedString(requestCacheExpiry))
            .append("\n")
        sb.append("    malId: ").append(toIndentedString(malId)).append("\n")
        sb.append("    url: ").append(toIndentedString(url)).append("\n")
        sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n")
        sb.append("    trailerUrl: ").append(toIndentedString(trailerUrl)).append("\n")
        sb.append("    title: ").append(toIndentedString(title)).append("\n")
        sb.append("    titleEnglish: ").append(toIndentedString(titleEnglish)).append("\n")
        sb.append("    titleJapanese: ").append(toIndentedString(titleJapanese)).append("\n")
        sb.append("    titleSynonyms: ").append(toIndentedString(titleSynonyms)).append("\n")
        sb.append("    type: ").append(toIndentedString(type)).append("\n")
        sb.append("    source: ").append(toIndentedString(source)).append("\n")
        sb.append("    episodes: ").append(toIndentedString(episodes)).append("\n")
        sb.append("    status: ").append(toIndentedString(status)).append("\n")
        sb.append("    airing: ").append(toIndentedString(airing)).append("\n")
        sb.append("    aired: ").append(toIndentedString(aired)).append("\n")
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n")
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n")
        sb.append("    score: ").append(toIndentedString(score)).append("\n")
        sb.append("    scoredBy: ").append(toIndentedString(scoredBy)).append("\n")
        sb.append("    rank: ").append(toIndentedString(rank)).append("\n")
        sb.append("    popularity: ").append(toIndentedString(popularity)).append("\n")
        sb.append("    members: ").append(toIndentedString(members)).append("\n")
        sb.append("    favorites: ").append(toIndentedString(favorites)).append("\n")
        sb.append("    synopsis: ").append(toIndentedString(synopsis)).append("\n")
        sb.append("    background: ").append(toIndentedString(background)).append("\n")
        sb.append("    premiered: ").append(toIndentedString(premiered)).append("\n")
        sb.append("    broadcast: ").append(toIndentedString(broadcast)).append("\n")
        sb.append("    producers: ").append(toIndentedString(producers)).append("\n")
        sb.append("    licensors: ").append(toIndentedString(licensors)).append("\n")
        sb.append("    studios: ").append(toIndentedString(studios)).append("\n")
        sb.append("    genres: ").append(toIndentedString(genres)).append("\n")
        sb.append("    openingThemes: ").append(toIndentedString(openingThemes)).append("\n")
        sb.append("    endingThemes: ").append(toIndentedString(endingThemes)).append("\n")
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