package com.example.moblabhw.view.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.moblabhw.R
import com.example.moblabhw.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val detailsViewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detailsViewModel.getDetails(1030)
        detailsViewModel.movieDetails.observe(this, Observer {
            details -> Log.d("DETAILS",details.toString())
        })
    }
}