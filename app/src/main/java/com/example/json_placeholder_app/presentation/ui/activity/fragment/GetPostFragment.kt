package com.example.json_placeholder_app.presentation.ui.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.json_placeholder_app.databinding.FragmentGetPostBinding
import com.example.json_placeholder_app.presentation.viewmodel.GetPostViewModel
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