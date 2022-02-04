package com.example.priyvratmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.priyvratmvvm.reository.MainRepository
import com.example.priyvratmvvm.R
import com.example.priyvratmvvm.adapters.MainAdapter
import com.example.priyvratmvvm.api.RetrofitService
import com.example.priyvratmvvm.viewmodel.MainViewModel
import com.example.priyvratmvvm.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel


    private val retrofitService = RetrofitService.getInstance()
    lateinit var  recyclerview:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recyclerview)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)

        recyclerview.layoutManager=LinearLayoutManager(this)


        viewModel.movieList.observe(this, Observer {
            recyclerview.adapter=MainAdapter(this,it)

        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,"Error while loading the data ",Toast.LENGTH_LONG).show()
        })
        viewModel.getAllMovies()

    }
}