package com.murattuzel.moviedb_sd.di.module

import com.murattuzel.moviedb_sd.ui.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindMovieFragment(): MoviesFragment
}