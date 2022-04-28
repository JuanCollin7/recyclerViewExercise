package com.jc.recyclerexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel<T>() : ViewModel() {

    private val _model = MutableLiveData<T>()
    val model: LiveData<T> = _model

    fun set(model: T) {
        _model.value = model!!
    }
}