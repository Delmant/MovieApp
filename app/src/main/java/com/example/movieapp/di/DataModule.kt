package com.example.movieapp.di

import com.example.movieapp.data.local_data_source.MovieLocalDataSource
import com.example.movieapp.data.local_data_source.MovieLocalDataSourceImpl
import com.example.movieapp.data.repository_impl.MovieRepositoryImpl
import com.example.movieapp.data.remote_data_source.ApiFactory
import com.example.movieapp.data.remote_data_source.ApiService
import com.example.movieapp.data.remote_data_source.MovieRemoteDataSource
import com.example.movieapp.data.remote_data_source.MovieRemoteDataSourceImpl
import com.example.movieapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    fun bindMovieRemoteDataSource(impl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    fun bindMovieLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }


    }
}