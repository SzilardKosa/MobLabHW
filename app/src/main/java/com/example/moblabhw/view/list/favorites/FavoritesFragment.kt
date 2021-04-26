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
import com.example.moblabhw.R
import com.example.moblabhw.util.FetchState
import com.example.moblabhw.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

//    private val favoritesViewModel: FavoritesViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)
    // Todo: java.lang.IllegalArgumentException: Cannot add the same observer with different lifecycles
    private val favoritesViewModel: FavoritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        favoritesViewModel.allFavorites.observe(viewLifecycleOwner, Observer {
                favorites -> Log.d("FAVORITES",favorites.toString())
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }
}