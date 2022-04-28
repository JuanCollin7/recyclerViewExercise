package com.jc.recyclerexercise.ui.photos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.Photo

class PhotoDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _photo = MutableLiveData<Photo>()
    val photo: LiveData<Photo> = _photo

    fun set(photo: Photo) {
        _photo.value = photo
    }
}