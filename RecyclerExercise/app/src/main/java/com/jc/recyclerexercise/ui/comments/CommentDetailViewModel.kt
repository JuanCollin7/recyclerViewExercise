package com.jc.recyclerexercise.ui.comments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.Comment

class CommentDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _comment = MutableLiveData<Comment>()
    val comment: LiveData<Comment> = _comment

    fun set(comment: Comment) {
        _comment.value = comment
    }
}