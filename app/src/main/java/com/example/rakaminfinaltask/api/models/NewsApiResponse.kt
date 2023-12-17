package com.example.rakaminfinaltask.api.models

data class NewsApiResponse(
    var status: String,
    var total: Int,
    var articles: List<NewHeadLine>
)
