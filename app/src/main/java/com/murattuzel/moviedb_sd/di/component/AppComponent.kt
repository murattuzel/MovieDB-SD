package com.murattuzel.moviedb_sd.di.component

import com.murattuzel.moviedb_sd.KApp
import com.murattuzel.moviedb_sd.di.module.ActivityModule
import com.murattuzel.moviedb_sd.di.module.AppModule
import com.murattuzel.moviedb_sd.di.module.FragmentModule
import com.murattuzel.moviedb_sd.di.module.NetworkModule
import com.murattuzel.moviedb_sd.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<KApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<KApp>
}