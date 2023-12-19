package com.example.rakaminfinaltask.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rakaminfinaltask.R
import com.example.rakaminfinaltask.api.models.NewHeadLine


class NewsTrendingAdapter(private val onClick: (NewHeadLine) -> Unit) :
    ListAdapter<NewHeadLine, NewsTrendingAdapter.NewsViewHolder>(NewsCallBack){
    class NewsViewHolder(itemView: View, val onClick: (NewHeadLine) -> Unit) :
        RecyclerView.ViewHolder(itemView){
        val imgHeadLineTrending : ImageView = itemView.findViewById(R.id.img_headline_news_trending)
        val txtTitleTrending : TextView = itemView.findViewById(R.id.text_title_news_trending)
        val txtDescTrending : TextView = itemView.findViewById(R.id.text_description_trending)
        val txtAuthorTrending : TextView = itemView.findViewById(R.id.text_author_news_trending)
        val txtDateTrending : TextView  =itemView.findViewById(R.id.text_date_news_trending)


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

            txtTitleTrending.text = news.title
            txtDescTrending.text = news.description
            txtAuthorTrending.text = news.author
            txtDateTrending.text = news.publishedAt

            Glide.with(itemView).load(news.urlToImage).centerCrop().into(imgHeadLineTrending)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_trending, parent, false)
        return NewsViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }


}

//object NewsCallBack : DiffUtil.ItemCallback<NewHeadLine>(){
//    override fun areItemsTheSame(oldItem: NewHeadLine, newItem: NewHeadLine): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: NewHeadLine, newItem: NewHeadLine): Boolean {
//        return oldItem.source?.id == newItem.source?.id
//    }
//
//}