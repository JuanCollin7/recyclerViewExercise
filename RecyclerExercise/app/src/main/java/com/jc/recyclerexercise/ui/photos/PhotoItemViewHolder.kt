package com.jc.recyclerexercise.ui.photos

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Photo

class PhotoItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val urlTextView: TextView = itemView.findViewById(R.id.urlTextView)

    fun setData(photo: Photo, itemInterface: ItemClickListener<Photo>) {
        titleTextView.text = photo.title
        urlTextView.text = photo.url

        itemView.setOnClickListener {
            itemInterface.onItemClicked(photo)
        }
    }
}