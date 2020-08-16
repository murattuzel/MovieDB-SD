package com.murattuzel.moviedb_sd.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w342/$url")
                .into(imageView)
        }
    }
}