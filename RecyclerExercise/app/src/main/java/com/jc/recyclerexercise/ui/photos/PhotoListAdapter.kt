package com.jc.recyclerexercise.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Photo

class PhotoListAdapter(private val itemInterface: ItemClickListener<Photo>): RecyclerView.Adapter<PhotoItemViewHolder>()  {

    var data = listOf<Photo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) {
        val item = data[position]
        holder.setData(item, itemInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.photo_item_view, parent, false) as CardView

        return PhotoItemViewHolder(view)
    }
}