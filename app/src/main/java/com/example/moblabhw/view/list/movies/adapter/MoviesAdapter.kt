package com.example.moblabhw.view.list.movies.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moblabhw.R
import com.example.moblabhw.databinding.MovieRowBinding
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.view.details.DetailsActivity
import com.example.moblabhw.viewmodel.MoviesViewModel

class MoviesAdapter(
    private val context: Context,
    private val moviesViewModel: MoviesViewModel
): ListAdapter<MovieModel, MoviesAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: MovieRowBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.movie_row,
            parent, false)
        binding.adapter = this
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    fun deleteMovie(movie: MovieModel) {
        moviesViewModel.delete(movie)
    }

    fun toggleFavorite(movie: MovieModel) {
        moviesViewModel.toggleFavorite(movie)
    }

    fun showDetails(movie: MovieModel) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY_MOVIE, movie.malId)
        context.startActivity(intent)
    }

    class ViewHolder(private val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieModel) {
            binding.movie = movie
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.malId == newItem.malId
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }
    }

}