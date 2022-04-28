package com.jc.recyclerexercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
data class Photo(var id: Int, var albumId: Int? = null, var title: String? = null, var url: String? = null, var thumbnailUrl: String? = null): Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) = Photo(
            jsonObject.getInt("id"),
            jsonObject.getInt("albumId"),
            jsonObject.getString("title"),
            jsonObject.getString("url"),
            jsonObject.getString("thumbnailUrl")
        )
    }
}