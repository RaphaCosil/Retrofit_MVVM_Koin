package com.example.retrofittest.presentation.ui.activity.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.retrofittest.R
import com.example.retrofittest.databinding.FragmentGetPostBinding
import com.example.retrofittest.databinding.FragmentUpdatePostBinding
import com.example.retrofittest.presentation.viewmodel.UpdatePostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdatePostFragment : Fragment() {

    companion object {
        fun newInstance() = UpdatePostFragment()
    }
    private lateinit var binding: FragmentUpdatePostBinding
    private val updatePostViewModel: UpdatePostViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdatePostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}