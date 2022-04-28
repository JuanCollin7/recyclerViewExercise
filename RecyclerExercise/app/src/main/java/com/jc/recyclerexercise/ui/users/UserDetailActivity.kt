package com.jc.recyclerexercise.ui.users

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.databinding.UserDetailActivityBinding
import com.jc.recyclerexercise.models.User

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: UserDetailActivityBinding

    private val viewModel: UserDetailViewModel by lazy {
        ViewModelProvider(this)[UserDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = intent.getParcelableExtra<User>(UserDetailActivity.ARG_USER) ?: return
        viewModel.set(post)

        viewModel.user.observe(this) { post ->
            setLayout(post)
        }
    }

    private fun setLayout(user: User) {
        binding.user = user
    }

    companion object {
        private const val ARG_USER = "USER"

        fun getInstance(context: Context, user: User) = Intent(context, UserDetailActivity::class.java).apply {
            putExtra(ARG_USER, user)
        }
    }
}