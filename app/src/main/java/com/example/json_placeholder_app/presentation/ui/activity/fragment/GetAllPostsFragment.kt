package com.example.json_placeholder_app.presentation.ui.activity.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.json_placeholder_app.databinding.FragmentGetAllPostsBinding
import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.presentation.ui.view.PostListAdapter
import com.example.json_placeholder_app.presentation.ui.style.SpaceItemDecoration
import com.example.json_placeholder_app.presentation.viewmodel.GetAllPostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GetAllPostsFragment : Fragment() {
    private lateinit var binding: FragmentGetAllPostsBinding
    private val getAllPostsViewModel: GetAllPostsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetAllPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            getAllPostsViewModel.getPosts()
            getAllPostsViewModel.posts.observe(viewLifecycleOwner) {
                Log.d("PostsViewModel", "getPosts result: $it")
                setupRecycler(it)
            }
        } catch (e: Exception) {
            Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
            Toast.makeText(requireContext(), "Error fetching posts", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setupRecycler(posts: List<PostEntity>) = binding.postsRecycleView.apply {
        val postsAdapter = PostListAdapter()
        postsAdapter.postsList = posts
        adapter = postsAdapter
        layoutManager = LinearLayoutManager(context)
        addItemDecoration(SpaceItemDecoration(48))
    }
}