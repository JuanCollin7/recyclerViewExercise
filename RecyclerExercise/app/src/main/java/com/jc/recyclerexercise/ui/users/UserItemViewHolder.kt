package com.jc.recyclerexercise.ui.users

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.User

class UserItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val phoneTextView: TextView = itemView.findViewById(R.id.bodyTextView)

    fun setData(user: User, itemInterface: ItemClickListener<User>) {
        nameTextView.text = user.name
        phoneTextView.text = user.phone

        itemView.setOnClickListener {
            itemInterface.onItemClicked(user)
        }
    }
}