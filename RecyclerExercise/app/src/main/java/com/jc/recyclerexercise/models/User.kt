package com.jc.recyclerexercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
class User(var id: Int, var name: String? = null, var username: String? = null, var phone: String? = null): Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) = User(
            jsonObject.getInt("id"),
            jsonObject.getString("name"),
            jsonObject.getString("username"),
            jsonObject.getString("phone")
        )
    }
}