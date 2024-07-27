package com.abc.kitsu.data.model

import com.abc.kitsu.domain.kitsu.model.Anime
import com.google.gson.annotations.SerializedName

data class AnimesResponse(

    @field:SerializedName("data")
    val animeDto: List<AnimeDto>
)

data class AnimeDto(

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("attributes")
    val attributes: Attributes
)

data class Attributes(

    @field:SerializedName("nextRelease")
    val nextRelease: String,

    @field:SerializedName("endDate")
    val endDate: Any,

    @field:SerializedName("episodeCount")
    val episodeCount: Any,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("ratingRank")
    val ratingRank: Int,

    @field:SerializedName("posterImage")
    val posterImage: PosterImage,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("subtype")
    val subtype: String,

    @field:SerializedName("youtubeVideoId")
    val youtubeVideoId: String,

    @field:SerializedName("averageRating")
    val averageRating: String,

    @field:SerializedName("coverImage")
    val coverImage: CoverImage,

    @field:SerializedName("showType")
    val showType: String,

    @field:SerializedName("abbreviatedTitles")
    val abbreviatedTitles: List<String>,

    @field:SerializedName("slug")
    val slug: String,

    @field:SerializedName("episodeLength")
    val episodeLength: Int,

    @field:SerializedName("updatedAt")
    val updatedAt: String,

    @field:SerializedName("nsfw")
    val nsfw: Boolean,

    @field:SerializedName("synopsis")
    val synopsis: String,

    @field:SerializedName("titles")
    val titles: Titles,

    @field:SerializedName("ageRating")
    val ageRating: String,

    @field:SerializedName("totalLength")
    val totalLength: Int,

    @field:SerializedName("favoritesCount")
    val favoritesCount: Int,

    @field:SerializedName("coverImageTopOffset")
    val coverImageTopOffset: Int,

    @field:SerializedName("canonicalTitle")
    val canonicalTitle: String,

    @field:SerializedName("tba")
    val tba: Any,

    @field:SerializedName("userCount")
    val userCount: Int,

    @field:SerializedName("popularityRank")
    val popularityRank: Int,

    @field:SerializedName("ageRatingGuide")
    val ageRatingGuide: String,

    @field:SerializedName("startDate")
    val startDate: String,

    @field:SerializedName("status")
    val status: String
)

data class Titles(

    @field:SerializedName("en")
    val en: String,
)

data class CoverImage(

    @field:SerializedName("small")
    val small: String,

    @field:SerializedName("original")
    val original: String,

    @field:SerializedName("large")
    val large: String,

    @field:SerializedName("tiny")
    val tiny: String
)

data class PosterImage(

    @field:SerializedName("small")
    val small: String,

    @field:SerializedName("original")
    val original: String,

    @field:SerializedName("large")
    val large: String,

    @field:SerializedName("tiny")
    val tiny: String,

    @field:SerializedName("medium")
    val medium: String
)

fun AnimeDto.toAnime() = Anime(
    id = id,
    title = attributes.canonicalTitle,
    image = attributes.posterImage.original,
    rating = attributes.averageRating,
    desc = attributes.synopsis
)