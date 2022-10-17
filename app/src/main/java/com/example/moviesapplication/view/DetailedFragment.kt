package com.example.moviesapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentDetailedBinding
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.model.Result

private  var movieList = ArrayList<com.example.moviesapplication.model.Result>()
private lateinit var binding: FragmentDetailedBinding
private var user = ArrayList<com.example.moviesapplication.model.Result>()
class DetailedFragment : Fragment(R.layout.fragment_detailed) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding.textView.text = "Reached Detailed Fragment"
    }


}