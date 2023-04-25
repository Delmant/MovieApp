package com.example.movieapp.di

import androidx.lifecycle.ViewModel
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    fun bindMovieDetailViewModel(impl: MovieDetailViewModel): ViewModel

}