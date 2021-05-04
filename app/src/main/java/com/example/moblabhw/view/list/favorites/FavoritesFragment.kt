package com.example.moblabhw.view.list.favorites

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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moblabhw.R
import com.example.moblabhw.databinding.FragmentFavoritesBinding
import com.example.moblabhw.util.FetchState
import com.example.moblabhw.view.list.favorites.adapter.FavoritesAdapter
import com.example.moblabhw.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

//    private val favoritesViewModel: FavoritesViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)
    private val favoritesViewModel: FavoritesViewModel by viewModels()
    lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesViewModel.getFavorites()
        favoritesViewModel.fetchState.observe(viewLifecycleOwner, Observer { fetchState ->
            when(fetchState){
                is FetchState.Success -> {
                    Log.d("FAVORITES", "Success")
                }
                is FetchState.Error -> {
                    Log.d("FAVORITES ERROR", fetchState.exception.message.toString())
                }
                is FetchState.Loading -> {
                    Log.d("FAVORITES", "Loading")
                }
            }
        })
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {

        favoritesAdapter = FavoritesAdapter(requireContext(), favoritesViewModel)

        val binding = FragmentFavoritesBinding.bind(view)

        binding.apply {
            listFavorites.apply {
                adapter = favoritesAdapter
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
                    val movie = favoritesAdapter.currentList[viewHolder.adapterPosition]
                    favoritesViewModel.delete(movie)
                }
            }).attachToRecyclerView(listFavorites)
        }


        favoritesViewModel.allFavorites.observe(viewLifecycleOwner, Observer { favorites ->
            favoritesAdapter.submitList(favorites)
//                favorites -> Log.d("FAVORITES",favorites.toString())
        })

    }
}