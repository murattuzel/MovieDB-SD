package com.murattuzel.moviedb_sd.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieItemResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String
)