package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.data.mapper.MovieMapper

import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.search_fragment.SearchFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity() : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var apiService = ApiFactory.apiService

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as MovieApp).component
    }


    private var viewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]

        coroutineScope.launch {
            val movie = MovieMapper().toEntity(apiService.getMovieById(8228))
            Log.d("CHECK1", "Test1")
            Log.d("CHECK2", movie.toString())
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MovieListFragment.newInstance(movie)).commit()

        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    coroutineScope.launch {
                        val movie = MovieMapper().toEntity(apiService.getMovieById(8228))
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, MovieListFragment.newInstance(movie))
                            .commit()

                    }
                    true
                }

                R.id.search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SearchFragment.newInstance()).commit()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel?.clearSearchSettings()
    }
    override fun onDestroy() {
        super.onDestroy()
        viewModel?.clearSearchSettings()
    }
}
