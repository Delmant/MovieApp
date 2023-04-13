package com.example.movieapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {



    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}