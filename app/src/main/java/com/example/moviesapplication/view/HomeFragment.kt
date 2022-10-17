package com.example.moviesapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapplication.R
import com.example.moviesapplication.adapter.MovieAdapter
import com.example.moviesapplication.databinding.ActivityMainBinding
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.model.OnMovieItemClickListener
import com.example.moviesapplication.viewModel.MovieViewModel

private lateinit var binding: FragmentHomeBinding
private lateinit var viewModel: MovieViewModel
private lateinit var movieAdapter : MovieAdapter
private  var movieList = ArrayList<com.example.moviesapplication.model.Result>()
class HomeFragment : Fragment() ,OnMovieItemClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
        return binding.root
    }
    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter(this)
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(activity,2)
            adapter = movieAdapter

        }
    }


    override fun onMovieItemClicked(position: Int) {


//            val user = movieList[position].title
//            val bundle = bundleOf("user" to user)


            view?.findNavController()?.navigate(R.id.detailed_Fragment)








    }




}