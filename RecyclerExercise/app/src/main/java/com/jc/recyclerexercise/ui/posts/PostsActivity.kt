package com.jc.recyclerexercise.ui.posts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.R

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.posts_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PostsFragment.newInstance())
                .commitNow()
        }
    }

    companion object {
        fun getInstance(context: Context) = Intent(context, PostsActivity::class.java)
    }
}