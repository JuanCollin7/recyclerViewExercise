package com.jc.recyclerexercise.ui.todos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.ToDoItem

class ToDoDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _toDoItem = MutableLiveData<ToDoItem>()
    val toDoItem: LiveData<ToDoItem> = _toDoItem

    fun set(toDoItem: ToDoItem) {
        _toDoItem.value = toDoItem
    }
}