package com.jc.recyclerexercise.ui.todos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.ToDoItem

class ToDoListAdapter(private val itemInterface: ItemClickListener<ToDoItem>): RecyclerView.Adapter<ToDoItemViewHolder>()  {

    var data = listOf<ToDoItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) {
        holder.setData(data[position], itemInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.todo_item_view, parent, false) as CardView

        return ToDoItemViewHolder(view)
    }
}