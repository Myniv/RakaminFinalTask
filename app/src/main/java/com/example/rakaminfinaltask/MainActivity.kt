package com.example.rakaminfinaltask

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
//import android.telecom.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rakaminfinaltask.api.ApiClient
import com.example.rakaminfinaltask.api.models.NewHeadLine
import com.example.rakaminfinaltask.api.models.NewsApiResponse
import com.example.rakaminfinaltask.api.adapter.NewsAdapter
import com.example.rakaminfinaltask.api.adapter.NewsTrendingAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerViewList: RecyclerView
    private lateinit var recyclerViewTrending: RecyclerView
    private lateinit var call: Call<NewsApiResponse>
    private lateinit var callTrending: Call<NewsApiResponse>
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsTrendingAdapter: NewsTrendingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeRefresh = findViewById(R.id.refresh_layout)
        recyclerViewList = findViewById(R.id.recycle_news_list)
        recyclerViewTrending = findViewById(R.id.recycle_news_trending)

        val button : Button = findViewById(R.id.btn_profile)
        button.setOnClickListener(this)



        newsAdapter = NewsAdapter { news -> newsOnClick(news)  }
        recyclerViewList.adapter = newsAdapter
        recyclerViewList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        newsTrendingAdapter = NewsTrendingAdapter { news -> newsOnClick(news)  }
        recyclerViewTrending.adapter = newsTrendingAdapter
        recyclerViewTrending.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        swipeRefresh.setOnRefreshListener {
            getDataNewsListTrending()
            getDataNewsList()
        }
        getDataNewsListTrending()
        getDataNewsList()
    }

    private fun newsOnClick(news : NewHeadLine){
        Toast.makeText(applicationContext, news.description, Toast.LENGTH_SHORT).show()
    }

    private fun getDataNewsList(){
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

    private fun getDataNewsListTrending(){
        swipeRefresh.isRefreshing = true

        callTrending = ApiClient.topHeadlineService.getAll()
        callTrending.enqueue(object : Callback<NewsApiResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>
            ) {
                swipeRefresh.isRefreshing = false
                if(response.isSuccessful){
                    newsTrendingAdapter.submitList(response.body()?.articles)
                    newsTrendingAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                swipeRefresh.isRefreshing = false
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_profile -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
    }
}

