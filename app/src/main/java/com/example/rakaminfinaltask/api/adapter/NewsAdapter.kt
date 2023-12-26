package com.example.rakaminfinaltask.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rakaminfinaltask.R
import com.example.rakaminfinaltask.api.models.NewHeadLine
import com.example.rakaminfinaltask.api.services.NewsCallBack


class NewsAdapter(private val onClick: (NewHeadLine) -> Unit) :
    ListAdapter<NewHeadLine, NewsAdapter.NewsViewHolder>(NewsCallBack){
    class NewsViewHolder(itemView: View, val onClick: (NewHeadLine) -> Unit) :
        RecyclerView.ViewHolder(itemView){
            val imgHeadLine : ImageView = itemView.findViewById(R.id.img_headline_news_list)
            val txtTitle : TextView = itemView.findViewById(R.id.text_title_news_list)
//            val txtDesc : TextView = itemView.findViewById(R.id.text_description)
            val txtAuthor : TextView = itemView.findViewById(R.id.text_author_news_list)
            val txtDate : TextView  =itemView.findViewById(R.id.text_date_news_list)

//            val imgHeadLineTrending : ImageView = itemView.findViewById(R.id.img_headline_trending)
//            val txtTitleTrending : TextView = itemView.findViewById(R.id.text_title_trending)
//            val txtDescTrending : TextView = itemView.findViewById(R.id.text_description_trending)

            var currentNews: NewHeadLine? = null

        init {
            itemView.setOnClickListener(){
                currentNews?.let{
                    onClick(it)
                }
            }
        }

        fun bind(news: NewHeadLine){
            currentNews = news

            txtTitle.text = news.title
//            txtDesc.text = news.description
            txtAuthor.text = news.author
            txtDate.text = news.publishedAt

//            txtTitleTrending.text = news.title
//            txtDescTrending.text = news.description

            Glide.with(itemView).load(news.urlToImage).centerCrop().into(imgHeadLine)
//            Glide.with(itemView).load(news.urlToImage).centerCrop().into(imgHeadLineTrending)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_items, parent, false)
        return NewsViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }


}