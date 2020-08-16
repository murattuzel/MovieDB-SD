package com.murattuzel.moviedb_sd

import com.murattuzel.moviedb_sd.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class KApp : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this);
    }


}