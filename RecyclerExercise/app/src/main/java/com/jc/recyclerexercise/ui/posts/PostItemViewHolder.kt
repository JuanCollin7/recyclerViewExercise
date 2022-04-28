package com.jc.recyclerexercise.ui.posts

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Post

class PostItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)

    fun setData(post: Post, itemInterface: ItemClickListener<Post>) {
        titleTextView.text = post.title
        bodyTextView.text = post.body

        itemView.setOnClickListener {
            itemInterface.onItemClicked(post)
        }
    }
}