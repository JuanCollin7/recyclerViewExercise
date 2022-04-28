package com.jc.recyclerexercise.ui.photos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.databinding.PhotoDetailActivityBinding
import com.jc.recyclerexercise.models.Photo


class PhotoDetailActivity : AppCompatActivity() {

    private lateinit var binding: PhotoDetailActivityBinding

    private val viewModel: PhotoDetailViewModel by lazy {
        ViewModelProvider(this)[PhotoDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PhotoDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photo = intent.getParcelableExtra<Photo>(ARG_PHOTO) ?: return
        viewModel.set(photo)

        viewModel.photo.observe(this) { photo ->
            setLayout(photo)
        }
    }

    private fun setLayout(photo: Photo) {
        binding.photo = photo

        val url = GlideUrl(photo.url,
                            LazyHeaders.Builder().addHeader("User-Agent", WebSettings.getDefaultUserAgent(this)).build())
        Glide.with(this).load(url).into(binding.photoDetailImageView);
    }

    companion object {
        private const val ARG_PHOTO = "PHOTO"

        fun getInstance(context: Context, photo: Photo) = Intent(context, PhotoDetailActivity::class.java).apply {
            putExtra(ARG_PHOTO, photo)
        }
    }
}