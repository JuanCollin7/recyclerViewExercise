package com.jc.recyclerexercise.ui.comments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.VolleyModule
import com.jc.recyclerexercise.models.Comment

class CommentsViewModel(application: Application) : AndroidViewModel(application) {

    private val volleyModule = VolleyModule(application)

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> = _comments

    init {
        getComments()
    }

    fun getComments() {
        volleyModule.getComments { list, error ->
            _comments.postValue(list)
        }
    }
}