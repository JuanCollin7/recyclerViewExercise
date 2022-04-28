package com.jc.recyclerexercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
class ToDoItem(var id: Int, var title: String? = null, var completed: Boolean? = null): Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) = ToDoItem(
            jsonObject.getInt("id"),
            jsonObject.getString("title"),
            jsonObject.getBoolean("completed")
        )
    }
}