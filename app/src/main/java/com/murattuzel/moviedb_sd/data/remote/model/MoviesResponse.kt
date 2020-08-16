package com.murattuzel.moviedb_sd.data.remote.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    val moviesResponse: List<MovieItemResponse>
)