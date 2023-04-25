package com.example.movieapp.di

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Provides


@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: MovieDetailFragment)

    fun inject(application: MovieApp)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}