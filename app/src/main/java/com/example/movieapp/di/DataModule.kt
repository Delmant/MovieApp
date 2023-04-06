package com.example.movieapp.di

import com.example.movieapp.data.MovieRepositoryImpl
import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    companion object {

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}