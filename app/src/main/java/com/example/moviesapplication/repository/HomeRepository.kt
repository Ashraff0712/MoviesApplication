package com.example.moviesapplication.repository


import androidx.lifecycle.MutableLiveData
import com.example.moviesapplication.model.Result
import com.example.moviesapplication.retrofit.MovieApi
import com.example.moviesapplication.retrofit.RetrofitInstance
import kotlinx.coroutines.*

const val apikey:String = "69d66957eebff9666ea46bd464773cf0"

class HomeRepository {
    private var movieLiveData = MutableLiveData<List<Result>>()
    val errorMessage = MutableLiveData<String>()
    var job:Job? = null

    val exceptionHandler = CoroutineExceptionHandler{_,
    throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }


    fun getPopularMovies() : MutableLiveData<List<Result>> {
        job = CoroutineScope(
            Dispatchers.IO +
                    exceptionHandler
        ).launch {
            val response = RetrofitInstance.getInstance().create(MovieApi::class.java)
            val res = response.getPopularMovies(apikey)
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    movieLiveData.postValue(res.body()?.results)
                }else{
                    onError("Error : ${res.message()}")
                }
            }

        }
        return movieLiveData
    }
        private fun onError(message: String) {
            errorMessage.value = message
        }



}