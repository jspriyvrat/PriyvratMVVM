package com.example.priyvratmvvm.reository

import com.example.priyvratmvvm.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService)
{

    fun getAllMovies() = retrofitService.getAllMovies()// this function is calling the getAllmovies method of the
    // retrofitservice class

}