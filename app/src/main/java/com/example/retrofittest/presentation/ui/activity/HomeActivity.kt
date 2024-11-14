package com.example.retrofittest.presentation.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.retrofittest.R
import com.example.retrofittest.databinding.ActivityMainBinding
import com.example.retrofittest.presentation.ui.activity.fragment.CreatePostFragment
import com.example.retrofittest.presentation.ui.activity.fragment.GetAllPostsFragment
import com.example.retrofittest.presentation.ui.activity.fragment.GetPostFragment
import com.example.retrofittest.presentation.ui.activity.fragment.UpdatePostFragment


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

        binding.btHome.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<GetAllPostsFragment>(R.id.fragment)
            }
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