package com.jc.recyclerexercise.ui.albums

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Album

class AlbumItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

    fun setData(album: Album, itemInterface: ItemClickListener<Album>) {
        titleTextView.text = album.title

        itemView.setOnClickListener {
            itemInterface.onItemClicked(album)
        }
    }
}