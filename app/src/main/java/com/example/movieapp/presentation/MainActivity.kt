package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.data.network.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val apiService = ApiFactory.apiService

    private val coroutineScopeDefault = CoroutineScope(Dispatchers.Default)
    private val coroutineScopeMain = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            coroutineScopeDefault.launch {
//                val movie1 = apiService.getMovieByPage(1,1)
//                Log.d("MOVIE", movie1.toString())
                val movie2 = apiService.getRandomMovie()
                Log.d("MOVIE", movie2.toString())
                coroutineScopeMain.launch {
                    binding.tvText.text = movie2.name
                    Glide.with(this@MainActivity)
                        .load("https://st.kp.yandex.net/images/film_big/${movie2    .id}.jpg")
                        .into(binding.ivMovieImg)

                }
            }
        }
//        val movieList = mutableListOf<MovieDto>()
//        coroutineScopeDefault.launch {
//            repeat(10) {
//                val movie = apiService.getRandomMovie()
//                movieList.add(movie)
//                Log.d("MOVIE", movie.toString())
//            }
//            coroutineScopeMain.launch {
//                setupRv(movieList)
//            }
//        }
//
    }

//    private fun setupRv(list: List<MovieDto>) {
//        val adapter = MovieAdapter(this)
//        binding.rvMovies.adapter = adapter
//        binding.rvMovies.layoutManager = GridLayoutManager(this ,4)
//        adapter.submitList(list)
//    }
    override fun onDestroy() {
        super.onDestroy()
        coroutineScopeDefault.cancel()
        coroutineScopeMain.cancel()
    }
}
