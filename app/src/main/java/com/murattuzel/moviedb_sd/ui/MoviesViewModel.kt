package com.murattuzel.moviedb_sd.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.murattuzel.moviedb_sd.data.remote.MovieApiRepository
import com.murattuzel.moviedb_sd.data.remote.Resource
import com.murattuzel.moviedb_sd.data.remote.Status
import com.murattuzel.moviedb_sd.data.remote.model.MovieItemResponse
import io.reactivex.disposables.CompositeDisposable

class MoviesViewModel @ViewModelInject constructor(
    private val movieApiRepository: MovieApiRepository
) :
    ViewModel() {

    private val disposable = CompositeDisposable()

    private val _moviesData = MutableLiveData<List<MovieItemResponse>>()
    val moviesData: LiveData<List<MovieItemResponse>>
        get() = _moviesData

    init {
        getMovies()
    }

    private fun getMovies() {
        disposable.add(
            movieApiRepository.fetchMovies()
                .startWith(Resource.loading(null))
                .subscribe(
                    {
                        Log.d("TAG", "getMovies: ${it.data}")
                        if (it.status == Status.SUCCESS) {
                            _moviesData.postValue(it.data?.moviesResponse)
                        }
                    },
                    { throwable ->
                        Log.d(
                            "TAG",
                            "throwable message: ${throwable.message}"
                        )
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}