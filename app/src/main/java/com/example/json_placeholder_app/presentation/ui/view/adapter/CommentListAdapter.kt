package com.example.json_placeholder_app.presentation.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_placeholder_app.databinding.ItemCommentBinding
import com.example.json_placeholder_app.domain.entity.CommentEntity
import com.example.json_placeholder_app.presentation.ui.view.click_listener.OnCommentClickListener

class CommentListAdapter(
    private val onCommentClickListener: OnCommentClickListener,
    private val commentList: List<CommentEntity>
): RecyclerView.Adapter<CommentListAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount() = commentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(ItemCommentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.binding.apply {
            val comment = commentList[position]
            textViewUsername.text = comment.name
            textViewBody.text = comment.body
        }
        holder.binding.textViewUsername.setOnClickListener {
            onCommentClickListener.onCommentClick(commentList[position].id)
        }
    }
}