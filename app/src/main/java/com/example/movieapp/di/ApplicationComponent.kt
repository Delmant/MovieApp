package com.example.movieapp.di

import android.app.Application
import dagger.Component
import dagger.BindsInstance

@Component
interface ApplicationComponent {

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}