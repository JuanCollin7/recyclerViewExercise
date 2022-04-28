package com.jc.recyclerexercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
class Post(var id: Int, var title: String? = null, var body: String? = null): Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) = Post(
            jsonObject.getInt("id"),
            jsonObject.getString("title"),
            jsonObject.getString("body")
        )
    }
}