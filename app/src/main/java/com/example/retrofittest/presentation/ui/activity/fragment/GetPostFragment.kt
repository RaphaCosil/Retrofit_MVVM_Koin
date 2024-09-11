package com.example.retrofittest.presentation.ui.activity.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofittest.R
import com.example.retrofittest.presentation.viewmodel.GetPostViewModel

class GetPostFragment : Fragment() {

    companion object {
        fun newInstance() = GetPostFragment()
    }

    private lateinit var viewModel: GetPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_get_post, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GetPostViewModel::class.java)
        // TODO: Use the ViewModel
    }

}