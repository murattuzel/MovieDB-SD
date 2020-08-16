package com.murattuzel.moviedb_sd.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.murattuzel.moviedb_sd.ui.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    internal abstract fun bindMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel
}