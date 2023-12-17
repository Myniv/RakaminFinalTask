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


class NewsAdapter(private val onClick: (NewHeadLine) -> Unit) :
    ListAdapter<NewHeadLine, NewsAdapter.NewsViewHolder>(NewsCallBack){
    class NewsViewHolder(itemView: View, val onClick: (NewHeadLine) -> Unit) :
        RecyclerView.ViewHolder(itemView){
            val imgHeadLine : ImageView = itemView.findViewById(R.id.img_headline)
            val txtTitle : TextView = itemView.findViewById(R.id.text_title)
            val txtDesc : TextView = itemView.findViewById(R.id.text_description)

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
            txtDesc.text = news.description

            Glide.with(itemView).load(news.urlToImage).centerCrop().into(imgHeadLine)
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

object NewsCallBack : DiffUtil.ItemCallback<NewHeadLine>(){
    override fun areItemsTheSame(oldItem: NewHeadLine, newItem: NewHeadLine): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NewHeadLine, newItem: NewHeadLine): Boolean {
        return oldItem.source?.id == newItem.source?.id
    }

}