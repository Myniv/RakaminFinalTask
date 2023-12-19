package com.example.rakaminfinaltask.api.services

import com.example.rakaminfinaltask.api.models.NewsApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface TopHeadlineService {
    @GET("v2/top-headlines?sources=bbc-news&apiKey=b386fab884a846d3893d51ecfe35e05f")
    fun getAll(): Call<NewsApiResponse>
}