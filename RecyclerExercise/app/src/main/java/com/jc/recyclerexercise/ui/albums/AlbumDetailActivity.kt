package com.jc.recyclerexercise.ui.albums

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.BaseViewModel
import com.jc.recyclerexercise.databinding.AlbumDetailActivityBinding
import com.jc.recyclerexercise.models.Album

class AlbumDetailActivity : AppCompatActivity() {

    private lateinit var binding: AlbumDetailActivityBinding

    private val viewModel: BaseViewModel<Album> by lazy {
        ViewModelProvider(this)[BaseViewModel<Album>()::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AlbumDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val album = intent.getParcelableExtra<Album>(AlbumDetailActivity.ARG_ALBUM) ?: return
        viewModel.set(album)

        viewModel.model.observe(this) { post ->
            setLayout(post)
        }
    }

    private fun setLayout(album: Album) {
        binding.album = album
    }

    companion object {
        private const val ARG_ALBUM = "ALBUM"

        fun getInstance(context: Context, album: Album) = Intent(context, AlbumDetailActivity::class.java).apply {
            putExtra(ARG_ALBUM, album)
        }
    }
}