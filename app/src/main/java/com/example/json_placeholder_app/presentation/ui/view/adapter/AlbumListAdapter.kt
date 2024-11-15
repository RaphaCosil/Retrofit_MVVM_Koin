package com.example.json_placeholder_app.presentation.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.json_placeholder_app.databinding.ItemAlbumBinding
import com.example.json_placeholder_app.domain.entity.AlbumEntity
import com.example.json_placeholder_app.presentation.ui.view.click_listener.OnUserInformationClickListener

class AlbumListAdapter(
    private val context: Context,
    private val albumList: List<AlbumEntity>,
    private val onUserInformationClickListener: OnUserInformationClickListener
) : RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount() = albumList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.binding.apply {
            val album = albumList[position]
            textViewUsername.text = album.userName
            textViewTitle.text = album.title
            val adapter = ImageListAdapter(album.photos)
            recyclerViewPhotos.adapter = adapter
            recyclerViewPhotos.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            recyclerViewPhotos.setHasFixedSize(true)
        }
        holder.binding.userImage.setOnClickListener {
            onUserInformationClickListener.onUserInformationClick(
                albumList[position].userId
            )
        }
        holder.itemView.setOnClickListener {
            onUserInformationClickListener.onUserInformationClick(
                albumList[position].userId
            )
        }
    }
}