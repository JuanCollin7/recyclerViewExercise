package com.jc.recyclerexercise.ui.comments

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Comment

class CommentItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
    private val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)

    fun setData(comment: Comment, itemInterface: ItemClickListener<Comment>) {
        nameTextView.text = comment.name
        emailTextView.text = comment.email
        bodyTextView.text = comment.body

        itemView.setOnClickListener {
            itemInterface.onItemClicked(comment)
        }
    }
}