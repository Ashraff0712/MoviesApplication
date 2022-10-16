package com.example.moviesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.findFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapplication.adapter.MovieAdapter
import com.example.moviesapplication.databinding.ActivityMainBinding
import com.example.moviesapplication.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private  lateinit var navController: NavController
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navControllerHome) as NavHostFragment
        navController = navHostFragment.navController
    }


}