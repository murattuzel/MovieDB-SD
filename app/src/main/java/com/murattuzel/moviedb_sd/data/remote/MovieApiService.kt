package com.murattuzel.moviedb_sd.data.remote

import com.murattuzel.moviedb_sd.data.remote.model.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieApiService {

    @GET("movie/popular")
    fun getPopularMovies(): Observable<MoviesResponse>
}