package com.example.retrofittest.presentation.ui.activity.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofittest.R
import com.example.retrofittest.presentation.viewmodel.UpdatePostViewModel

class UpdatePostFragment : Fragment() {

    companion object {
        fun newInstance() = UpdatePostFragment()
    }

    private lateinit var viewModel: UpdatePostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_post, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpdatePostViewModel::class.java)
        // TODO: Use the ViewModel
    }

}