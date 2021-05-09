package com.example.moblabhw.test

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.moblabhw.database.CacheMapper
import com.example.moblabhw.database.MovieDatabase
import com.example.moblabhw.mock.network.MockFavoritesApi
import com.example.moblabhw.mock.network.MockMoviesApi
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import androidx.test.core.app.ApplicationProvider
import com.example.moblabhw.mock.db.MockMoviesDAO
import com.example.moblabhw.repository.DetailsRepository
import com.example.moblabhw.util.DataState
import com.example.moblabhw.util.getOrAwaitValue
import com.example.moblabhw.viewmodel.DetailsViewModel
import org.junit.*
import org.robolectric.annotation.Config
import java.io.IOException
import java.lang.Exception
import kotlin.jvm.Throws

@Config(manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner::class)
class DetailsTest {

    private lateinit var detailsViewModel: DetailsViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val moviesDAO = MockMoviesDAO()
        val moviesApi = MockMoviesApi()
        val favoritesApi = MockFavoritesApi()
        val cacheMapper = CacheMapper()

        val detailsRepository = DetailsRepository(moviesDAO, moviesApi, cacheMapper, favoritesApi)
        detailsViewModel = DetailsViewModel(detailsRepository)
    }

    @Test
    fun test_getDetails(){
        // Arrange

        // Act
        detailsViewModel.getDetails(0)
        var details = detailsViewModel.movieDetails.getOrAwaitValue()

        // Assert
        if (details is DataState.Success){
            Assert.assertEquals(0, details.data.malId)
            Assert.assertEquals("Test 1", details.data.title)
            Assert.assertEquals(7.3f, details.data.score)
        } else {
            throw Exception("Details DataState is not Success")
        }
    }

    @Test
    fun test_toggleFavorite() {
        // Arrange
        detailsViewModel.getDetails(0)
        var isFavoriteBefore = detailsViewModel.isFavorite.getOrAwaitValue()

        // Act
        detailsViewModel.toggleFavorite(0)
        var isFavoriteAfter = detailsViewModel.isFavorite.getOrAwaitValue()

        // Assert
        Assert.assertEquals(false, isFavoriteBefore)
        Assert.assertEquals(true, isFavoriteAfter)

    }

}