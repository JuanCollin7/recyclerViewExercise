package com.jc.recyclerexercise

import android.app.Application
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.jc.recyclerexercise.models.*
import org.json.JSONException

class VolleyModule(private val context: Application) {

    fun getUsers(onResult: (list: List<User>, error: VolleyError?) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val url = "https://jsonplaceholder.typicode.com/users"

        val request = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            { response ->
                val list: MutableList<User> = ArrayList()

                for (i in 0 until response.length()) {
                    try {
                        list.add(
                            User.fromJson(response.getJSONObject(i))
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                onResult(list, null)
            },
            {
                onResult(emptyList(), it)
            })

        queue.add(request)
    }

    fun getPosts(onResult: (list: List<Post>, error: VolleyError?) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val url = "https://jsonplaceholder.typicode.com/posts"

        val request = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            { response ->
                val list: MutableList<Post> = ArrayList()

                for (i in 0 until response.length()) {
                    try {
                        list.add(
                            Post.fromJson(response.getJSONObject(i))
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                onResult(list, null)
            },
            {
                onResult(emptyList(), it)
            })

        queue.add(request)
    }

    fun getToDoItems(onResult: (list: List<ToDoItem>, error: VolleyError?) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val url = "https://jsonplaceholder.typicode.com/todos"

        val request = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            { response ->
                val list: MutableList<ToDoItem> = ArrayList()

                for (i in 0 until response.length()) {
                    try {
                        list.add(
                            ToDoItem.fromJson(response.getJSONObject(i))
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                onResult(list, null)
            },
            {
                onResult(emptyList(), it)
            })

        queue.add(request)
    }

    fun getComments(onResult: (list: List<Comment>, error: VolleyError?) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val url = "https://jsonplaceholder.typicode.com/comments"

        val request = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            { response ->
                val list: MutableList<Comment> = ArrayList()

                for (i in 0 until response.length()) {
                    try {
                        list.add(
                            Comment.fromJson(response.getJSONObject(i))
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                onResult(list, null)
            },
            {
                onResult(emptyList(), it)
            })

        queue.add(request)
    }

    fun getAlbums(onResult: (list: List<Album>, error: VolleyError?) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val url = "https://jsonplaceholder.typicode.com/albums"

        val request = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            { response ->
                val list: MutableList<Album> = ArrayList()

                for (i in 0 until response.length()) {
                    try {
                        list.add(
                            Album.fromJson(response.getJSONObject(i))
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                onResult(list, null)
            },
            {
                onResult(emptyList(), it)
            })

        queue.add(request)
    }

    fun getPhotos(onResult: (list: List<Photo>, error: VolleyError?) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val url = "https://jsonplaceholder.typicode.com/photos"

        val request = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            { response ->
                val list: MutableList<Photo> = ArrayList()

                for (i in 0 until response.length()) {
                    try {
                        list.add(
                            Photo.fromJson(response.getJSONObject(i))
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                onResult(list, null)
            },
            {
                onResult(emptyList(), it)
            })

        queue.add(request)
    }
}