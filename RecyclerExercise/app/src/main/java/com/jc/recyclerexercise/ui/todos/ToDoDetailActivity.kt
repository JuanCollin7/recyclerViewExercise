package com.jc.recyclerexercise.ui.todos

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.databinding.TodoDetailActivityBinding
import com.jc.recyclerexercise.models.ToDoItem

class ToDoDetailActivity : AppCompatActivity() {

    private lateinit var binding: TodoDetailActivityBinding

    private val viewModel: ToDoDetailViewModel by lazy {
        ViewModelProvider(this)[ToDoDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TodoDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = intent.getParcelableExtra<ToDoItem>(ToDoDetailActivity.ARG_TO_DO) ?: return
        viewModel.set(post)

        viewModel.toDoItem.observe(this) { post ->
            setLayout(post)
        }
    }

    private fun setLayout(toDoItem: ToDoItem) {
        binding.toDoItem = toDoItem
    }

    companion object {
        private const val ARG_TO_DO = "TO_DO"

        fun getInstance(context: Context, toDoItem: ToDoItem) = Intent(context, ToDoDetailActivity::class.java).apply {
            putExtra(ARG_TO_DO, toDoItem)
        }
    }
}