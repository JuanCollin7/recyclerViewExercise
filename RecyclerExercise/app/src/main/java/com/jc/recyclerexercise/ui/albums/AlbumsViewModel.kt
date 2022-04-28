package com.jc.recyclerexercise.ui.albums

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.VolleyModule
import com.jc.recyclerexercise.models.Album

class AlbumsViewModel(application: Application) : AndroidViewModel(application) {

    private val volleyModule = VolleyModule(application)

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    init {
        getAlbums()
    }

    fun getAlbums() {
        volleyModule.getAlbums { list, error ->
            _albums.postValue(list)
        }
    }
}