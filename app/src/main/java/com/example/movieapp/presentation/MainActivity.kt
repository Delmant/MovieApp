package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.test.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val bindning by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)
        button.setOnClickListener {
            coroutineScope.launch {
                val retrofit = ApiFactory.apiService.getRandomMovie()
                Log.d("MOVIE", retrofit.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}