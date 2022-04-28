package com.jc.recyclerexercise.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.User

class UserListAdapter(private val userItemClickListener: ItemClickListener<User>): RecyclerView.Adapter<UserItemViewHolder>()  {

    var data = listOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.setData(data[position], userItemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.user_item_view, parent, false) as CardView

        return UserItemViewHolder(view)
    }
}