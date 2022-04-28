package com.jc.recyclerexercise.ui.posts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.Post

class PostDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> = _post

    fun set(post: Post) {
        _post.value = post
    }
}