package com.example.yomicepa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.yomicepa.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //enableEdgeToEdge()
        setContentView(binding.root)
        val customTitleView = layoutInflater.inflate(R.layout.custom_title, null)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navHostFragment.findNavController().run {
            binding.toolBar.setupWithNavController(this, AppBarConfiguration(graph))
            binding.toolBar.addView(customTitleView)
        }
//
    }
}