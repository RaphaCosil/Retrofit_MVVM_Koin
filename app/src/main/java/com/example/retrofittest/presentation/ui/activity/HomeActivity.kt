package com.example.retrofittest.presentation.ui.activity

import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.R
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.databinding.ActivityMainBinding
import com.example.retrofittest.presentation.ui.activity.fragment.CreatePostFragment
import com.example.retrofittest.presentation.ui.activity.fragment.GetAllPostsFragment
import com.example.retrofittest.presentation.ui.activity.fragment.GetPostFragment
import com.example.retrofittest.presentation.ui.activity.fragment.UpdatePostFragment
import com.example.retrofittest.presentation.ui.view.RecycleAdapter
import com.example.retrofittest.presentation.ui.view.SpaceItemDecoration
import com.example.retrofittest.presentation.viewmodel.GetAllPostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.HttpException
import java.io.IOException

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<GetAllPostsFragment>(R.id.fragment)
        }

        binding.btAddPublication.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<CreatePostFragment>(R.id.fragment)
            }
        }
        binding.btSearch.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<GetPostFragment>(R.id.fragment)
            }
        }
        binding.btEdit.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<UpdatePostFragment>(R.id.fragment)
            }
        }

    }
}