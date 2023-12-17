package com.example.rakaminfinaltask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.telecom.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rakaminfinaltask.api.ApiClient
import com.example.rakaminfinaltask.api.models.NewHeadLine
import com.example.rakaminfinaltask.api.models.NewsApiResponse
import com.example.rakaminfinaltask.api.adapter.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var call: Call<NewsApiResponse>
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeRefresh = findViewById(R.id.refresh_layout)
        recyclerView = findViewById(R.id.recycle_news_list)

        newsAdapter = NewsAdapter { news -> newsOnClick(news)  }
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        swipeRefresh.setOnRefreshListener {
            getData()
        }
        getData()
    }

    private fun newsOnClick(news : NewHeadLine){
        Toast.makeText(applicationContext, news.description, Toast.LENGTH_SHORT).show()
    }

    private fun getData(){
        swipeRefresh.isRefreshing = true

        call = ApiClient.newsService.getAll()
        call.enqueue(object : Callback<NewsApiResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>
            ) {
                swipeRefresh.isRefreshing = false
                if(response.isSuccessful){
                    newsAdapter.submitList(response.body()?.articles)
                    newsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                swipeRefresh.isRefreshing = false
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}