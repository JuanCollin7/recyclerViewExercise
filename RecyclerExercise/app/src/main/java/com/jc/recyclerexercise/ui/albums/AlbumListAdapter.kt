package com.jc.recyclerexercise.ui.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.models.Album

class AlbumListAdapter(private val itemInterface: ItemClickListener<Album>): RecyclerView.Adapter<AlbumItemViewHolder>()  {

    var data = listOf<Album>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: AlbumItemViewHolder, position: Int) {
        holder.setData(data[position], itemInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.album_item_view, parent, false) as CardView

        return AlbumItemViewHolder(view)
    }
}