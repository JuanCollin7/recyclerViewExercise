package com.jc.recyclerexercise.ui.todos

import android.widget.Switch
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.ToDoItem

class ToDoItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val switch: Switch = itemView.findViewById(R.id.switch1)

    fun setData(toDoItem: ToDoItem, itemInterface: ItemClickListener<ToDoItem>) {
        titleTextView.text = toDoItem.title
        switch.isChecked = toDoItem.completed ?: false

        itemView.setOnClickListener {
            itemInterface.onItemClicked(toDoItem)
        }
    }
}