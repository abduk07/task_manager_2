package com.example.taskmanager2

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(urlString: String?) {
    Glide.with(this).load(urlString).into(this)
}