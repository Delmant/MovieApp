package com.example.movieapp.di

import androidx.lifecycle.ViewModel
import com.example.movieapp.presentation.actor_detail_fragment.ActorDetailViewModel
import com.example.movieapp.presentation.image_detail_fragment.ImageDetailViewModel
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailViewModel
import com.example.movieapp.presentation.review_detail_fragment.ReviewDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    fun bindMovieDetailViewModel(impl: MovieDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ActorDetailViewModel::class)
    fun bindActorDetailViewModel(impl: ActorDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ImageDetailViewModel::class)
    fun bindImageDetailViewModel(impl: ImageDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReviewDetailViewModel::class)
    fun bindReviewDetailViewModel(impl: ReviewDetailViewModel): ViewModel
}