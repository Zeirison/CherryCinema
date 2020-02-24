package com.example.cherrycinema.data.remote.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class UpComingResult(
    val results: List<Movie>,
    val page: Int,
    @JsonProperty(value = "total_pages")
    val totalPages: Int
)