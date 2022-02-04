package com.example.priyvratmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.priyvratmvvm.reository.MainRepository
import com.example.priyvratmvvm.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()// here we are creating the List of  movielist
    val errorMessage = MutableLiveData<String>()// here we are creating an error message list

    fun getAllMovies() {

        val response = repository.getAllMovies()// here we are calling the getAllmovies method of class repository
        response.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())// here we are adding the response data to the movielist
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message) // here we are adding the error messages to the error message list
            }
        })
    }
}