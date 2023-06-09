package com.example.movieapp.di

import androidx.lifecycle.ViewModel
import com.example.movieapp.presentation.MainActivityViewModel
import com.example.movieapp.presentation.actor_detail_fragment.ActorDetailViewModel
import com.example.movieapp.presentation.image_detail_fragment.ImageDetailViewModel
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailViewModel
import com.example.movieapp.presentation.review_detail_fragment.ReviewDetailViewModel
import com.example.movieapp.presentation.review_list_fragment.ReviewListViewModel
import com.example.movieapp.presentation.search_fragment.SearchViewModel
import com.example.movieapp.presentation.search_setting_fragment.SearchSettingsViewModel
import com.example.movieapp.presentation.search_settings_detail_fragment.SearchSettingsDetailViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(impl: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReviewListViewModel::class)
    fun bindReviewListViewModel(impl: ReviewListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchSettingsViewModel::class)
    fun bindSearchSettingsViewModel(impl: SearchSettingsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchSettingsDetailViewModel::class)
    fun bindSearchSettingsDetailViewModel(impl: SearchSettingsDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun bindMainActivityViewModel(impl: MainActivityViewModel): ViewModel
}