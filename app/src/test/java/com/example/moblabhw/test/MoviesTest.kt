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
import com.example.moblabhw.util.getOrAwaitValue
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
class MoviesTest {

    private lateinit var moviesViewModel: MoviesViewModel
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

        moviesViewModel = MoviesViewModel(moviesRepository, favoritesRepository)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun test_getMovies(){
        moviesViewModel.getMovies()
        var movies = moviesViewModel.allMovies.getOrAwaitValue()
        Assert.assertEquals(3, movies.size)
        Assert.assertEquals(
            MovieModel(
            malId = 0,
            title = "Test 1",
            score = 7.3f,
            members = 123,
            imageUrl = "url",
            url = "url",
            airing = false,
            episodes = 1,
            rated = "R",
            type = "Movie",
            synopsis = "Blablabal",
            startDate = Date("1/1/2020"),
            endDate = Date("1/1/2020"),
            isFavorite = false
        ), movies[0])
    }

    @Test
    fun test_delete(){
        moviesViewModel.getMovies()
        var movies = moviesViewModel.allMovies.getOrAwaitValue()
        moviesViewModel.delete(movies[0])
        movies = moviesViewModel.allMovies.getOrAwaitValue()

        Assert.assertEquals(2, movies.size)
        Assert.assertThat(movies, not(hasItem(MovieModel(
            malId = 0,
            title = "Test 1",
            score = 7.3f,
            members = 123,
            imageUrl = "url",
            url = "url",
            airing = false,
            episodes = 1,
            rated = "R",
            type = "Movie",
            synopsis = "Blablabal",
            startDate = Date("1/1/2020"),
            endDate = Date("1/1/2020"),
            isFavorite = false
        ))))
    }

    @Test
    fun test_toggleFavorite() {
        moviesViewModel.getMovies()
        var movies = moviesViewModel.allMovies.getOrAwaitValue()
        moviesViewModel.toggleFavorite(movies[0])
        movies = moviesViewModel.allMovies.getOrAwaitValue()

        Assert.assertEquals(3, movies.size)
        Assert.assertEquals(true, movies[0].isFavorite)
    }

}