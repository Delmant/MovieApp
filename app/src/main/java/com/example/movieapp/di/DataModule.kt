package com.example.movieapp.di

import com.example.movieapp.data.repository_impl.MovieRepositoryImpl
import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.data.remote_data_source.MovieRemoteDataSource
import com.example.movieapp.data.remote_data_source.MovieRemoteDataSourceImpl
import com.example.movieapp.data.repository_impl.SearchSettingsRepositoryImpl
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.repository.SearchSettingsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    fun bindSearchSettingsRepository(impl: SearchSettingsRepositoryImpl): SearchSettingsRepository

    @Binds
    fun bindMovieRemoteDataSource(impl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }


    }
}