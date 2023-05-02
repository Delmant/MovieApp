package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.data.mapper.MovieMapper

import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity() : AppCompatActivity() {

    private var apiService = ApiFactory.apiService

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        coroutineScope.launch {
            val movie = MovieMapper().toEntity(apiService.getMovieById(8228))
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MovieListFragment.newInstance(movie)).commit()

        }

    }
}
