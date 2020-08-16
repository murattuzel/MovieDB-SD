package com.murattuzel.moviedb_sd.di.module

import com.murattuzel.moviedb_sd.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}