package com.example.movieapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.presentation.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    abstract fun bindsViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory
}