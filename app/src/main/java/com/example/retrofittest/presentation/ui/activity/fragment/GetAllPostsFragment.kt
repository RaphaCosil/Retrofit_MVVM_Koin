package com.example.retrofittest.presentation.ui.activity.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.R
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.databinding.FragmentGetAllPostsBinding
import com.example.retrofittest.presentation.ui.view.RecycleAdapter
import com.example.retrofittest.presentation.ui.view.SpaceItemDecoration
import com.example.retrofittest.presentation.viewmodel.GetAllPostsViewModel

class GetAllPostsFragment : Fragment() {
    private lateinit var binding: FragmentGetAllPostsBinding

    private val getAllPostsViewModel: GetAllPostsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetAllPostsBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_get_all_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            getAllPostsViewModel.getPosts()
            getAllPostsViewModel.posts.observe(viewLifecycleOwner) {
                setupRecycler(it)
            }
        } catch (e: Exception) {
            Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
        }

    }
    private fun setupRecycler(posts: List<PostData>) {
        val adapter = RecycleAdapter()
        adapter.postsList = posts.toMutableList()
        binding.postsRecycleView.adapter = adapter
        binding.postsRecycleView.layoutManager = LinearLayoutManager(context)
        binding.postsRecycleView.addItemDecoration(SpaceItemDecoration(10))
    }
}