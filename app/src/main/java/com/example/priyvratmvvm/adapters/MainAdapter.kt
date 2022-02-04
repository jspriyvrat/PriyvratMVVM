package com.example.priyvratmvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.priyvratmvvm.model.Movie
import com.example.priyvratmvvm.R

class MainAdapter(val context: Context,val articles: List<Movie>):RecyclerView.Adapter<MainAdapter.InnerClass>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerClass {
    val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.adapter_movie,parent,false)
        return InnerClass(view) // here we are returning the inner class object
    }

    override fun onBindViewHolder(holder: InnerClass, position: Int) {
        val article = articles[position]
    holder.movieName.text=article.Title
        holder.year.text=article.Year
        holder.imdbID.text=article.imdbID
        Glide.with(context).load(article.Poster).into(holder.image)
        // here we are setting the contents in the corresponding views
    }

    override fun getItemCount(): Int {
        return  articles.size // here we are returning the size of the article list
    }
    class InnerClass(itemView:View) :RecyclerView.ViewHolder(itemView){
        // this is inner class to initialize the views
        val image: ImageView=itemView.findViewById(R.id.myImage)
        val movieName:TextView=itemView.findViewById(R.id.movieName)
        val year:TextView=itemView.findViewById(R.id.year)
        val imdbID:TextView=itemView.findViewById(R.id.imdbID)

    }

}