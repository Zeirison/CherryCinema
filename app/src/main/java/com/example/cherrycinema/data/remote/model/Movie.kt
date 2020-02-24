package com.example.cherrycinema.data.remote.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Movie (
    val id: Int,
    val title: String,
    @JsonProperty(value = "original_title")
    val originalTitle: String,
    @JsonProperty(value = "poster_path")
    val posterPath: String,
    @JsonProperty(value = "backdrop_path")
    val backdropPath: String,
    val popularity: String,
    @JsonProperty(value = "vote_count")
    val voteCount: Int,
    @JsonProperty(value = "original_language")
    val originalLanguage: String,
    @JsonProperty(value = "vote_average")
    val voteAverage: Float,
    val overview: String,
    @JsonProperty(value = "release_date")
    val releaseDate: String,
    val video: Boolean,
    val adult: Boolean
)