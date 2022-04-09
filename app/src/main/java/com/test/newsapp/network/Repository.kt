package com.test.newsapp.network

class Repository constructor( val apiService: ApiService ) {
    fun getNews() = apiService.getNews()
}