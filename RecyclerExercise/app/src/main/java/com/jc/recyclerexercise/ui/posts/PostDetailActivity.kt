package com.jc.recyclerexercise.ui.posts

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.databinding.PostDetailActivityBinding
import com.jc.recyclerexercise.models.Post

class PostDetailActivity : AppCompatActivity() {

    private lateinit var binding: PostDetailActivityBinding

    private val viewModel: PostDetailViewModel by lazy {
        ViewModelProvider(this)[PostDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PostDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = intent.getParcelableExtra<Post>(PostDetailActivity.ARG_POST) ?: return
        viewModel.set(post)

        viewModel.post.observe(this) { post ->
            setLayout(post)
        }
    }

    private fun setLayout(post: Post) {
        binding.post = post
    }

    companion object {
        private const val ARG_POST = "POST"

        fun getInstance(context: Context, post: Post) = Intent(context, PostDetailActivity::class.java).apply {
            putExtra(ARG_POST, post)
        }
    }
}