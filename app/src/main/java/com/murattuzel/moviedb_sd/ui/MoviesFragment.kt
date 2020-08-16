package com.murattuzel.moviedb_sd.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.murattuzel.moviedb_sd.R
import com.murattuzel.moviedb_sd.databinding.FragmentMoviesBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesFragment : DaggerFragment() {

    private lateinit var binding: FragmentMoviesBinding

    @Inject
    lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.rvMovies.adapter = moviesAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeMovies()
        moviesAdapter.movieItemClick = {
            Toast.makeText(context, it.title, Toast.LENGTH_LONG).show()
        }
    }

    private fun observeMovies() {
        viewModel.moviesData.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "observeMovies: $it")
            if (it != null)
                moviesAdapter.setItems(it)
        })
    }
}