package com.example.priyvratmvvm.api

import com.example.priyvratmvvm.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const  val BASE_URL="http://www.omdbapi.com/?apikey=1d094e25&s=fast&type=movie&page=1"

interface RetrofitService  {

    @GET
    fun getAllMovies(): Call<List<Movie>>
    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}