package com.example.moviesapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.navArgument
import com.example.moviesapplication.model.Movies
import com.example.moviesapplication.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.moviesapplication.model.Result
import com.example.moviesapplication.repository.HomeRepository


class MovieViewModel : ViewModel() {

    var movieLiveData: MutableLiveData<List<Result>>?= null
    private var homeRepository:HomeRepository?= null
    private val movieList = ArrayList<Result>()
    fun setHomeRepository(homeRepository: HomeRepository){
        this.homeRepository = homeRepository
    }

    fun getPopularMovies(): MutableLiveData<List<Result>>? {
        movieLiveData = homeRepository?.getPopularMovies()
        return movieLiveData
    }

    fun sendData(position:Int): String {
         return movieList[position].title
    }


}