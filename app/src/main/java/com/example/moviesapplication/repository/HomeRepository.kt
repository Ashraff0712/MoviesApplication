package com.example.moviesapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapplication.model.Movies
import com.example.moviesapplication.model.Result
import com.example.moviesapplication.retrofit.RetrofitInstance
import kotlinx.coroutines.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
const val apikey:String = "69d66957eebff9666ea46bd464773cf0"

class HomeRepository {
    private var movieLiveData = MutableLiveData<List<Result>>()


    fun getPopularMovies() : MutableLiveData<List<Result>> {

        val call = RetrofitInstance.api.getPopularMovies(apikey)
        call.enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body() != null) {
                    movieLiveData.postValue(response.body()?.results)
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })

        return movieLiveData
    }

}