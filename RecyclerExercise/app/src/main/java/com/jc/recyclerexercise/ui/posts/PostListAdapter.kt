package com.jc.recyclerexercise.ui.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Post

class PostListAdapter(private val itemInterface: ItemClickListener<Post>): RecyclerView.Adapter<PostItemViewHolder>()  {

    var data = listOf<Post>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.setData(data[position], itemInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.user_item_view, parent, false) as CardView

        return PostItemViewHolder(view)
    }
}