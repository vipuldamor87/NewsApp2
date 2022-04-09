package com.test.newsapp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.newsapp.databinding.RowRecylerBinding
import com.test.newsapp.model.NewsData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class RecyclerAdapter(val newsData: NewsData) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(val binding: RowRecylerBinding, val newsData: NewsData) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(position: Int) {
            binding.newsData = newsData.articles[position]

            Glide.with(NewsActivity.context1).load(newsData.articles[position].urlToImage).into(binding.ivImage)


            binding.cvHold.setOnClickListener {
                var intent = Intent(NewsActivity.context1,NewsDetailActiviry::class.java)
                intent.putExtra("headline", newsData.articles[position].title)
                intent.putExtra("imageUrl", newsData.articles[position].urlToImage)
                intent.putExtra("author", newsData.articles[position].author)
                intent.putExtra("time", newsData.articles[position].publishedAt)
                intent.putExtra("url", newsData.articles[position].url)
                intent.putExtra("desc", newsData.articles[position].description)
                NewsActivity.context1.startActivity(intent)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: RowRecylerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_recyler,
            parent,
            false
        )
        return ViewHolder(binding, newsData)
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.row_recyler, parent, false)

//        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return newsData.articles.size
    }
}