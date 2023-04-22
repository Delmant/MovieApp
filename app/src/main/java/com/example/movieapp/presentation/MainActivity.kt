package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.movieapp.R

import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.databinding.MovieListBinding
import com.example.movieapp.databinding.TestBinding
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.rv.MovieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity() : AppCompatActivity() {

    private var apiService = ApiFactory.apiService

    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val coroutineScopeUi = CoroutineScope(Dispatchers.Main)

    private val binding: TestBinding by lazy {
        TestBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            coroutineScope.launch {
                val movie = apiService.getRandomMovie()
                coroutineScopeUi.launch {
                    binding.textView.text = movie.name
                    Log.d("MOVIE", movie.toString())

                   Glide.with(this@MainActivity)
                        .load("https://st.kp.yandex.net/images/film_big/${movie.id}.jpg")
                        .into(binding.imageView)
                }
            }
        }
    }
}
