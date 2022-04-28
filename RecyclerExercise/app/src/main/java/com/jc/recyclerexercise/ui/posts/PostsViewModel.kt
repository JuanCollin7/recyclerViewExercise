package com.jc.recyclerexercise.ui.posts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.VolleyModule
import com.jc.recyclerexercise.models.Post

class PostsViewModel(application: Application) : AndroidViewModel(application) {

    private val volleyModule = VolleyModule(application)

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        getUsers()
    }

    fun getUsers() {
        volleyModule.getPosts { list, error ->
            _posts.postValue(list)
        }
    }
}