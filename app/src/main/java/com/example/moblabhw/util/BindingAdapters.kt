package com.example.moblabhw.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @BindingAdapter(value = ["setImageUrl"])
    @JvmStatic fun ImageView.bindImageUrl(url: String?) {
        if (url != null && url.isNotBlank()) {
            Glide.with(this.context)
                .load(url)
                .into(this)
        }
    }
}