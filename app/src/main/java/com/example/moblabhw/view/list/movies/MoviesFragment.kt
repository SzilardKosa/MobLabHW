package com.example.moblabhw.view.list.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.moblabhw.R
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.util.DataState
import com.example.moblabhw.util.FetchState
import com.example.moblabhw.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

//    private val moviesViewModel: MoviesViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)
    // Todo: java.lang.IllegalArgumentException: Cannot add the same observer with different lifecycles
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moviesViewModel.getMovies()
        moviesViewModel.fetchState.observe(viewLifecycleOwner, Observer { fetchState ->
            when(fetchState){
                is FetchState.Success -> {
                    Log.d("MOVIES", "Success")
                }
                is FetchState.Error -> {
                    Log.d("MOVIES", fetchState.exception.message.toString())
                }
                is FetchState.Loading -> {
                    Log.d("MOVIES", "Loading")
                }
            }
        })
        moviesViewModel.allMovies.observe(viewLifecycleOwner, Observer { movies ->
            Log.d("MOVIES", movies.toString())
        } )
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }
}