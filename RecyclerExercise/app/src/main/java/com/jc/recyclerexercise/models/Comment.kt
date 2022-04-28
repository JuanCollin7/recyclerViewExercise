package com.jc.recyclerexercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
class Comment(var id: Int, var postId: Int? = null, var name: String? = null, var email: String? = null, var body: String? = null): Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) = Comment(
            jsonObject.getInt("id"),
            jsonObject.getInt("postId"),
            jsonObject.getString("name"),
            jsonObject.getString("email"),
            jsonObject.getString("body")
        )
    }
}