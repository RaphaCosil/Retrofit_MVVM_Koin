package com.example.retrofittest.presentation.ui.activity.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.retrofittest.R
import com.example.retrofittest.databinding.FragmentGetAllPostsBinding
import com.example.retrofittest.databinding.FragmentGetPostBinding
import com.example.retrofittest.presentation.viewmodel.GetPostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GetPostFragment : Fragment() {

    companion object {
        fun newInstance() = GetPostFragment()
    }
    private lateinit var binding: FragmentGetPostBinding
    private val getPostViewModel: GetPostViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetPostBinding.inflate(inflater, container, false)
        return binding.root // Retorna a View correta do binding
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}