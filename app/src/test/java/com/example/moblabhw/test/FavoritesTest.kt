package com.example.moblabhw.test

import android.content.Context
import android.os.Looper.getMainLooper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.moblabhw.database.CacheMapper
import com.example.moblabhw.database.MovieDatabase
import com.example.moblabhw.mock.network.MockFavoritesApi
import com.example.moblabhw.mock.network.MockMoviesApi
import com.example.moblabhw.network.NetworkMapper
import com.example.moblabhw.repository.FavoritesRepository
import com.example.moblabhw.repository.MoviesRepository
import com.example.moblabhw.viewmodel.MoviesViewModel
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import androidx.test.core.app.ApplicationProvider
import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.Movie
import com.example.moblabhw.util.getOrAwaitValue
import com.example.moblabhw.viewmodel.FavoritesViewModel
import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.core.IsNot.not
import org.junit.*
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.io.IOException
import java.util.*
import kotlin.jvm.Throws

@Config(manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner::class)
class FavoritesTest {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var db: MovieDatabase

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, MovieDatabase::class.java)
            .allowMainThreadQueries().build()
        val moviesDAO = db.moviesDAO()

        val moviesApi = MockMoviesApi()
        val favoritesApi = MockFavoritesApi()

        val cacheMapper = CacheMapper()
        val networkMapper = NetworkMapper()

        val moviesRepository = MoviesRepository(moviesDAO, moviesApi, cacheMapper, networkMapper)
        val favoritesRepository = FavoritesRepository(moviesDAO, favoritesApi, cacheMapper)

        favoritesViewModel = FavoritesViewModel(moviesRepository, favoritesRepository)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun test_getFavorites(){
        favoritesViewModel.getFavorites()
        var favorites = favoritesViewModel.allFavorites.getOrAwaitValue()
        Assert.assertEquals(3, favorites.size)
    }

    @Test
    fun test_toggleFavorite(){
        favoritesViewModel.getFavorites()
        var favorites = favoritesViewModel.allFavorites.getOrAwaitValue()
        favoritesViewModel.toggleFavorite(favorites[0])
        favorites = favoritesViewModel.allFavorites.getOrAwaitValue()

        Assert.assertEquals(2, favorites.size)
        Assert.assertEquals(1, favorites[0].malId)
        Assert.assertEquals("Test 2", favorites[0].title)
    }

    @Test
    fun test_delete(){
        favoritesViewModel.getFavorites()
        var favorites = favoritesViewModel.allFavorites.getOrAwaitValue()
        favoritesViewModel.delete(favorites[0])
        favorites = favoritesViewModel.allFavorites.getOrAwaitValue()

        Assert.assertEquals(2, favorites.size)
        Assert.assertEquals(1, favorites[0].malId)
        Assert.assertEquals("Test 2", favorites[0].title)
    }

}