package com.example.rakaminfinaltask.api.Models

data class NewsApiResponse(
    var status: String,
    var total: Int,
    var articles: List<NewHeadLine>
)
