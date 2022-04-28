package com.jc.recyclerexercise.ui.todos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.VolleyModule
import com.jc.recyclerexercise.models.ToDoItem

class ToDosViewModel(application: Application) : AndroidViewModel(application) {

    private val volleyModule = VolleyModule(application)

    private val _items = MutableLiveData<List<ToDoItem>>()
    val items: LiveData<List<ToDoItem>> = _items

    init {
        getToDoItems()
    }

    fun getToDoItems() {
        volleyModule.getToDoItems { list, error ->
            _items.postValue(list)
        }
    }
}