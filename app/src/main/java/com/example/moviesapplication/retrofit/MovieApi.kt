package com.example.moviesapplication.retrofit

import com.example.moviesapplication.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
const val apikey:String = "69d66957eebff9666ea46bd464773cf0"

interface MovieApi {
    @GET("popular?")
     fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>
}