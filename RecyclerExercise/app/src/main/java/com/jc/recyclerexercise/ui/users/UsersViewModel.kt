package com.jc.recyclerexercise.ui.users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.User
import com.jc.recyclerexercise.VolleyModule

class UsersViewModel(application: Application) : AndroidViewModel(application) {

    private val volleyModule = VolleyModule(application)

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        getUsers()
    }

    fun getUsers() {
        volleyModule.getUsers { list, error ->
            _users.postValue(list)
        }
    }
}