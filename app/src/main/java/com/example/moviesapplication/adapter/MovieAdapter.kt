package com.example.moviesapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapplication.MyDiffUtil
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.MovieLayoutBinding
import com.example.moviesapplication.model.OnMovieItemClickListener
import com.example.moviesapplication.view.DetailedFragment


class MovieAdapter(private val onMovieItemClickListener: OnMovieItemClickListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var oldItemList = emptyList<com.example.moviesapplication.model.Result>()
    private var movieList = ArrayList<com.example.moviesapplication.model.Result>()
    fun setMovieList(movieList: List<com.example.moviesapplication.model.Result>) {
        this.movieList = movieList as ArrayList<com.example.moviesapplication.model.Result>

        val diffUtil = MyDiffUtil(oldItemList,movieList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldItemList = movieList
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].title


        val movie = movieList[position]
        holder.itemView.setOnClickListener{
            onMovieItemClickListener.onMovieItemClicked(position)
        }


    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}