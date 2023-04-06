package com.example.movieapp.presentation

import Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.data.network.model.MovieDto
import com.example.movieapp.databinding.MovieListBinding
import com.example.movieapp.presentation.rv.MovieAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private val binding: MovieListBinding by lazy {
        MovieListBinding.inflate(layoutInflater)
    }

    private val apiService = ApiFactory.apiService

    private val coroutineScopeDefault = CoroutineScope(Dispatchers.Default)
    private val coroutineScopeMain = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

//        binding.btn.setOnClickListener {
//            coroutineScopeDefault.launch {
//                val movie = apiService.getRandomMovie()
//
//                val movieList = apiService.getMovieByPage(1, 10)
//                Log.d("MOVIE_LIST",movieList.toString())
//
//                coroutineScopeMain.launch {
//                    binding.tvText.text = movie.name
//                    Glide.with(this@MainActivity)
//                        .load("https://st.kp.yandex.net/images/film_big/${movie.id}.jpg")
//                        .into(binding.ivMovieImg)
//                    Log.d("MOVIE", movie.toString())
//                }
//            }
//        }
        val movieList = mutableListOf<MovieDto>()
        coroutineScopeDefault.launch {
            repeat(60) {
                val movie = apiService.getRandomMovie()
                movieList.add(movie)
                Log.d("MOVIE", movie.toString())
            }
            coroutineScopeMain.launch {
                setupRv(movieList)
            }
        }

    }

    private fun setupRv(list: List<MovieDto>) {
        val adapter = MovieAdapter(this)
        binding.rvMovies.adapter = adapter
        binding.rvMovies.layoutManager = GridLayoutManager(this ,4)
        adapter.submitList(list)
    }
    override fun onDestroy() {
        super.onDestroy()
        coroutineScopeDefault.cancel()
        coroutineScopeMain.cancel()
    }
}