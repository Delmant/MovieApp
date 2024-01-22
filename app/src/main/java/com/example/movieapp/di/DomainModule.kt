package com.example.movieapp.di

import com.example.movieapp.data.repository_impl.MovieRepositoryImpl
import com.example.movieapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}