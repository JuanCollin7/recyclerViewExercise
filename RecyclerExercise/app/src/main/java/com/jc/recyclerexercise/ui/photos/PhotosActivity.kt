package com.jc.recyclerexercise.ui.photos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.recyclerexercise.R

class PhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photos_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PhotosFragment.newInstance())
                .commitNow()
        }
    }

    companion object {
        fun getInstance(context: Context) = Intent(context, PhotosActivity::class.java)
    }
}