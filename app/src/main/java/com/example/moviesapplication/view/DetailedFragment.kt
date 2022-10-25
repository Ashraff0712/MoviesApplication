package com.example.moviesapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentDetailedBinding
import com.example.moviesapplication.viewModel.MovieViewModel


class DetailedFragment : Fragment(R.layout.fragment_detailed) {

    private lateinit var binding: FragmentDetailedBinding
    private  var user:Bundle?= null
    private var fullInfo:Bundle? = null
    private val sharedViewModel:MovieViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            user = bundle.getBundle("user")
            fullInfo = bundle.getBundle("fullInfo")


        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDetailedBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = arguments?.getString("user")
        binding.textView4.text = arguments?.getString("fullInfo")
    }


}