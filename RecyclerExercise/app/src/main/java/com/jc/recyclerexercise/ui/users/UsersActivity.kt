package com.jc.recyclerexercise.ui.users

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.R

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UsersFragment.newInstance())
                .commitNow()
        }
    }

    companion object {
        fun getInstance(context: Context) = Intent(context, UsersActivity::class.java)
    }
}