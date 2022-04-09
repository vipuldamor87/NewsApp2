package com.test.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.test.newsapp.databinding.ActivityNewsDetailActiviryBinding

class NewsDetailActiviry : AppCompatActivity() {

    lateinit var binding: ActivityNewsDetailActiviryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsDetailActiviryBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        intent.putExtra("imageUrl", newsData.articles[position].urlToImage)
//        intent.putExtra("author", newsData.articles[position].author)
//        intent.putExtra("time", newsData.articles[position].publishedAt)
//        intent.putExtra("url", newsData.articles[position].url)
//        intent.putExtra("desc", newsData.articles[position].description)
        var imageUrl = intent.extras!!.get("imageUrl")

        Glide.with(this).load(imageUrl).into(binding.ivImage)



    }
}