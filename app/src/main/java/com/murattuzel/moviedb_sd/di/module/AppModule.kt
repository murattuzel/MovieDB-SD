package com.murattuzel.moviedb_sd.di.module

import android.app.Application
import android.content.Context
import com.murattuzel.moviedb_sd.KApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideApplication(application: KApp): Application {
        return application;
    }

    @Provides
    fun provideAppContext(application: KApp): Context {
        return application
    }
}