package com.example.rakaminfinaltask.api.services

import com.example.rakaminfinaltask.api.Models.NewHeadLine
import  retrofit2.Call
import retrofit2.http.GET


interface NewsService {
    @GET('/v2/everything')
    fun getAll(): Call<NewHeadLine>
}