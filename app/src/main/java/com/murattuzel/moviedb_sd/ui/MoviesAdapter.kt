package com.murattuzel.moviedb_sd.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murattuzel.moviedb_sd.data.remote.model.MovieItemResponse
import com.murattuzel.moviedb_sd.databinding.ItemMovieBinding
import javax.inject.Inject

class MoviesAdapter @Inject constructor() : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var moviesList: MutableList<MovieItemResponse> = mutableListOf()

    var movieItemClick: ((MovieItemResponse) -> Unit)? = null

    fun setItems(moviesList: List<MovieItemResponse>) {
        this.moviesList.clear()
        this.moviesList.addAll(moviesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return MoviesViewHolder(binding, movieItemClick)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    inner class MoviesViewHolder(
        private val binding: ItemMovieBinding,
        private val movieItemClick: ((MovieItemResponse) -> Unit)?
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieItemResponse: MovieItemResponse) {
            binding.item = movieItemResponse
            binding.root.setOnClickListener { movieItemClick?.invoke(movieItemResponse) }
            binding.executePendingBindings()
        }
    }
}