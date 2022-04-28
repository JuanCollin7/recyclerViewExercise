package com.jc.recyclerexercise.ui.comments

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.databinding.CommentDetailActivityBinding
import com.jc.recyclerexercise.models.Comment

class CommentDetailActivity : AppCompatActivity() {

    private lateinit var binding: CommentDetailActivityBinding

    private val viewModel: CommentDetailViewModel by lazy {
        ViewModelProvider(this)[CommentDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CommentDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = intent.getParcelableExtra<Comment>(CommentDetailActivity.ARG_COMMENT) ?: return
        viewModel.set(post)

        viewModel.comment.observe(this) { post ->
            setLayout(post)
        }
    }

    private fun setLayout(comment: Comment) {
        binding.comment = comment
    }

    companion object {
        private const val ARG_COMMENT = "COMMENT"

        fun getInstance(context: Context, comment: Comment) = Intent(context, CommentDetailActivity::class.java).apply {
            putExtra(ARG_COMMENT, comment)
        }
    }
}