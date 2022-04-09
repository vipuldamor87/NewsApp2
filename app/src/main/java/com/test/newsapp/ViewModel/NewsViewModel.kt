package com.test.newsapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.newsapp.model.NewsData
import com.test.newsapp.network.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewModel constructor( private  val repository: Repository): ViewModel() {

    val newsList = MutableLiveData<NewsData>()
    val errorMessage = MutableLiveData<String>()


    fun getNews(){
        val response = repository.getNews()
        response.enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                Log.e("Response",response.body().toString())
                newsList.postValue(response.body())
            }
            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.e("erro1r",t.message.toString())
                errorMessage.postValue(t.message)
            }
        })
    }
}