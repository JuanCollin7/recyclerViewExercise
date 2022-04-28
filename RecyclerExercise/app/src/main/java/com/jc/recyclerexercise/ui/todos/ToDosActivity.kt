package com.jc.recyclerexercise.ui.todos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.R

class ToDosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todos_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ToDosFragment.newInstance())
                .commitNow()
        }
    }

    companion object {
        fun getInstance(context: Context) = Intent(context, ToDosActivity::class.java)
    }
}