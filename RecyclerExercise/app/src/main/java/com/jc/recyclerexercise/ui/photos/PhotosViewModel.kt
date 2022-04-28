package com.jc.recyclerexercise.ui.photos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.VolleyModule
import com.jc.recyclerexercise.models.Photo

class PhotosViewModel(application: Application) : AndroidViewModel(application) {

    private val volleyModule = VolleyModule(application)

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    init {
        getPhotos()
    }

    fun getPhotos() {
        volleyModule.getPhotos { list, error ->
            _photos.postValue(list)
        }
    }
}