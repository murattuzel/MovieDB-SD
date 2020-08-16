package com.murattuzel.moviedb_sd.data.remote

import com.murattuzel.moviedb_sd.data.remote.model.MoviesResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieApiRepository @Inject constructor(private val apiService: MovieApiService) {

    fun fetchMovies(): Observable<Resource<MoviesResponse>> {
        return apiService.getPopularMovies()
            .map { moviesResponse: MoviesResponse -> Resource.success(moviesResponse) }
            .onErrorReturn { throwable: Throwable -> Resource.error(throwable.message, null) }
            .subscribeOn(Schedulers.io())
    }
}