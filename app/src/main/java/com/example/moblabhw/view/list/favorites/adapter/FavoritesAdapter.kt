package com.example.moblabhw.view.list.favorites.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moblabhw.R
import com.example.moblabhw.databinding.FavoriteRowBinding
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.view.details.DetailsActivity
import com.example.moblabhw.view.list.movies.adapter.MoviesAdapter
import com.example.moblabhw.viewmodel.FavoritesViewModel

class FavoritesAdapter(
    private val context: Context,
    private val favoritesViewModel: FavoritesViewModel
): ListAdapter<MovieModel, FavoritesAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: FavoriteRowBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.favorite_row,
            parent, false)
        binding.adapter = this
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    fun deleteMovie(movie: MovieModel) {
        favoritesViewModel.delete(movie)
    }

    fun toggleFavorite(movie: MovieModel) {
        favoritesViewModel.toggleFavorite(movie)
    }

    fun showDetails(movie: MovieModel) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY_MOVIE, movie.malId)
        context.startActivity(intent)
    }

    class ViewHolder(private val binding: FavoriteRowBinding) : RecyclerView.ViewHolder(binding.root) {
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