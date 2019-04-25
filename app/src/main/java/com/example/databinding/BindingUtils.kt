package com.example.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class BindingUtils {

}

@BindingAdapter("app:imageAvatar")
fun loadImage(view: ImageView, url: String) {
    Picasso.get()
        .load(url)
        .into(view)
}