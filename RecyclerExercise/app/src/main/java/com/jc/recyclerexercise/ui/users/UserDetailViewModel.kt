package com.jc.recyclerexercise.ui.users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.User

class UserDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun set(user: User) {
        _user.value = user
    }
}