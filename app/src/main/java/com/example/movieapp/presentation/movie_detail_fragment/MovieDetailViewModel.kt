package com.example.movieapp.presentation.movie_detail_fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(

) : ViewModel() {



    fun openYouTube(context: Context, link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.google.android.youtube")

        context.startActivity(intent)
    }
}