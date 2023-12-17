package com.example.rakaminfinaltask.api.services

import com.example.rakaminfinaltask.api.models.NewsApiResponse
import  retrofit2.Call
import retrofit2.http.GET


interface NewsService {
    @GET("v2/everything?q=bitcoin&apiKey=b386fab884a846d3893d51ecfe35e05f")
    fun getAll(): Call<NewsApiResponse>
}