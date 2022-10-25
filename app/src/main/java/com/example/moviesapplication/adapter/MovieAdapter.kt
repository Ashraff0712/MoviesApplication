package com.example.moviesapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapplication.MyDiffUtil
import com.example.moviesapplication.databinding.MovieLayoutBinding
import com.example.moviesapplication.model.Result


class MovieAdapter(private val onItemClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var oldItemList = emptyList<Result>()
    private var movieList = ArrayList<Result>()
    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList as ArrayList<Result>

        val diffUtil = MyDiffUtil(oldItemList, movieList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldItemList = movieList
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }

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
        holder.itemView.setOnClickListener {
            onItemClicked(position)
        }


    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}