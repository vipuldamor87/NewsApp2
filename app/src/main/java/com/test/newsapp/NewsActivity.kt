package com.test.newsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.newsapp.ViewModel.MyViewModelFactory
import com.test.newsapp.ViewModel.NewsViewModel
import com.test.newsapp.databinding.ActivityNewsBinding
import com.test.newsapp.network.ApiService
import com.test.newsapp.network.Repository

class NewsActivity : AppCompatActivity() {
    lateinit var  binding: ActivityNewsBinding
    private  lateinit var viewModel : NewsViewModel
    private val apiService = ApiService.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context1 = this



        viewModel = ViewModelProvider(this, MyViewModelFactory(Repository(apiService))).get(
            NewsViewModel::class.java)

        viewModel.newsList.observe(this, Observer {
            Log.e("asd",it.toString())
            binding.rvNews.layoutManager = LinearLayoutManager(this)
            binding.rvNews.adapter = RecyclerAdapter(it)
        })
        viewModel.getNews()

//        setContentView(R.layout.activity_news)
    }

    companion object{
        lateinit var context1: Context
    }
}