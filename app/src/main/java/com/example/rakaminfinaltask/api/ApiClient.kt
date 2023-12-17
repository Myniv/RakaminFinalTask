package com.example.rakaminfinaltask.api

import com.example.rakaminfinaltask.api.services.NewsService
import com.example.rakaminfinaltask.api.services.TopHeadlineService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://newsapi.org/"

    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsService: NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }

    val topHeadlineService : TopHeadlineService by lazy {
        retrofit.create(TopHeadlineService::class.java)
    }

}