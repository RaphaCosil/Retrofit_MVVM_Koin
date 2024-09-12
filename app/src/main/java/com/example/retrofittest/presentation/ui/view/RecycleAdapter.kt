package com.example.retrofittest.presentation.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.databinding.ItemRecycleBinding
class RecycleAdapter : RecyclerView.Adapter<RecycleAdapter.PostViewHolder>() {
    inner class PostViewHolder(val binding: ItemRecycleBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<PostData>() {
        override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var postsList: List<PostData>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = postsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(ItemRecycleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.apply {
            val posts = postsList[position]
            textViewTitle.text = posts.title
            textViewBody.text = posts.body
        }
    }
}