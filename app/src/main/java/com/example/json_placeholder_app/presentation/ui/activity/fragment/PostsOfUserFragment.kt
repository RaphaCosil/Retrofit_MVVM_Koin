package com.example.json_placeholder_app.presentation.ui.activity.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.json_placeholder_app.R
import com.example.json_placeholder_app.presentation.viewmodel.PostsOfUserViewModel

class PostsOfUserFragment : Fragment() {

    companion object {
        fun newInstance() = PostsOfUserFragment()
    }

    private lateinit var viewModel: PostsOfUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts_of_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostsOfUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}