package com.jc.recyclerexercise.ui.albums

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jc.recyclerexercise.models.Album

class AlbumDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    fun set(album: Album) {
        _album.value = album
    }
}