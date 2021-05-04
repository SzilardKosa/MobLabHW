package com.example.moblabhw.view.list.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moblabhw.R
import com.example.moblabhw.databinding.FragmentMoviesBinding
import com.example.moblabhw.util.FetchState
import com.example.moblabhw.view.list.movies.adapter.MoviesAdapter
import com.example.moblabhw.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

//    private val moviesViewModel: MoviesViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)
    private val moviesViewModel: MoviesViewModel by viewModels()
    lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {

        moviesAdapter = MoviesAdapter(requireContext(), moviesViewModel)

        val binding = FragmentMoviesBinding.bind(view)

        binding.apply {
            listMovies.apply {
                adapter = moviesAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val movie = moviesAdapter.currentList[viewHolder.adapterPosition]
                    moviesViewModel.delete(movie)
                }
            }).attachToRecyclerView(listMovies)
        }

        moviesViewModel.allMovies.observe(viewLifecycleOwner, Observer { movies ->
             moviesAdapter.submitList(movies)
//            Log.d("MOVIES", movies.toString())
        } )
    }


}