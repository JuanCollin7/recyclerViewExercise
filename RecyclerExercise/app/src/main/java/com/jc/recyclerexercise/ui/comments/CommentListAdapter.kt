package com.jc.recyclerexercise.ui.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Comment

class CommentListAdapter(private val itemInterface: ItemClickListener<Comment>): RecyclerView.Adapter<CommentItemViewHolder>()  {

    var data = listOf<Comment>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CommentItemViewHolder, position: Int) {
        holder.setData(data[position], itemInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.comment_item_view, parent, false) as CardView

        return CommentItemViewHolder(view)
    }
}