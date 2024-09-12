package com.example.retrofittest.presentation.ui.activity.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.retrofittest.R
import com.example.retrofittest.databinding.FragmentCreatePostBinding
import com.example.retrofittest.databinding.FragmentGetPostBinding
import com.example.retrofittest.presentation.viewmodel.CreatePostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreatePostFragment : Fragment() {

    companion object {
        fun newInstance() = CreatePostFragment()
    }
    private lateinit var binding: FragmentCreatePostBinding
    private val createPostViewModel: CreatePostViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}