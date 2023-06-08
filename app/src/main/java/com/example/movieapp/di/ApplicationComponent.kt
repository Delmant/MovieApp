package com.example.movieapp.di

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.movieapp.presentation.MainActivity
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.actor_detail_fragment.ActorDetailFragment
import com.example.movieapp.presentation.image_detail_fragment.ImageDetailFragment
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailFragment
import com.example.movieapp.presentation.review_detail_fragment.ReviewDetailFragment
import com.example.movieapp.presentation.review_list_fragment.ReviewListFragment
import com.example.movieapp.presentation.search_fragment.SearchFragment
import com.example.movieapp.presentation.search_setting_fragment.SearchSettingsFragment
import com.example.movieapp.presentation.search_settings_detail_fragment.SearchSettingsDetailFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Provides


@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: MovieDetailFragment)

    fun inject(fragment: SearchSettingsFragment)

    fun inject(fragment: SearchSettingsDetailFragment)

    fun inject(fragment: ActorDetailFragment)

    fun inject(fragment: ImageDetailFragment)

    fun inject(fragment: ReviewDetailFragment)

    fun inject(fragment: ReviewListFragment)

    fun inject(activity: MainActivity)

    fun inject(fragment: SearchFragment)

    fun inject(application: MovieApp)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}