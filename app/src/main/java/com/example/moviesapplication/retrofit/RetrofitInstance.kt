package com.example.moviesapplication.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP


object RetrofitInstance {
    const val BASE_URL = "https://api.themoviedb.org/3/movie/"



   fun getInstance():Retrofit {
       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()

   }

}