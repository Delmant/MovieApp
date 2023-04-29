package com.example.movieapp.presentation

import android.app.Application
import com.example.movieapp.di.DaggerApplicationComponent


class MovieApp: Application() {


    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}