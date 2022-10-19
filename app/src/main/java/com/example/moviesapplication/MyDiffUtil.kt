package com.example.moviesapplication

import com.example.moviesapplication.model.Result
import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(private val oldList: List<Result>,private val newList: List<Result>): DiffUtil.Callback(


) {
    /**
     * Returns the size of the old list.
     *
     * @return The size of the old list.
     */

    override fun getOldListSize(): Int {
        return oldList.size
    }


    override fun getNewListSize(): Int {
       return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id ->{
                false
            }
            oldList[oldItemPosition].title != newList[newItemPosition].title ->{
                false
            }
            else ->true

        }

    }
}