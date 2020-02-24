package com.example.cherrycinema.ui.movieList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cherrycinema.data.remote.model.Movie
import com.example.cherrycinema.databinding.ItemMovieBinding
import com.example.cherrycinema.ui.movie.MovieActivity
import com.google.android.material.card.MaterialCardView
import javax.inject.Singleton

@Singleton
class MovieListAdapter : PagedListAdapter<Movie, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let { (holder as MovieViewHolder).bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie) {
            binding.apply {
                movie = item
                executePendingBindings()
            }

            val card = binding.movieCard as MaterialCardView
            card.setOnClickListener {
                val movieOptions = MovieActivity.MovieOptions(
                    title = item.title,
                    overview = item.overview,
                    poster_path = item.posterPath,
                    rating = item.voteAverage.toString()
                )
                MovieActivity.startActivity(card.context, movieOptions)
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ) = oldItem == newItem
        }
    }

}