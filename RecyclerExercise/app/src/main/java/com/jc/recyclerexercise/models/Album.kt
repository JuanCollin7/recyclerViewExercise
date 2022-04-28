package com.jc.recyclerexercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
class Album(var id: Int, var userId: Int? = null, var title: String? = null): Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) = Album(
            jsonObject.getInt("id"),
            jsonObject.getInt("userId"),
            jsonObject.getString("title")
        )
    }
}