package com.example.json_placeholder_app.presentation.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.json_placeholder_app.R
import com.example.json_placeholder_app.databinding.ActivityMainBinding
import com.example.json_placeholder_app.presentation.ui.activity.fragment.CreatePostFragment
import com.example.json_placeholder_app.presentation.ui.activity.fragment.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<HomeFragment>(R.id.fragment)
        }

        binding.btHome.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<HomeFragment>(R.id.fragment)
            }
        }
        binding.btAddPublication.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<CreatePostFragment>(R.id.fragment)
            }
        }
    }
}