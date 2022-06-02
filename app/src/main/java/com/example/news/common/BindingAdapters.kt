package com.example.news.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.news.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, str: String?) {
    str?.let {
        val options = RequestOptions.placeholderOf(R.drawable.loading).error(R.drawable.error)
        Glide.with(view).setDefaultRequestOptions(options).load(str).into(view)
    }
}