package com.example.rakaminfinaltask.api.services

import androidx.recyclerview.widget.DiffUtil
import com.example.rakaminfinaltask.api.models.NewHeadLine

object NewsCallBack : DiffUtil.ItemCallback<NewHeadLine>(){
    override fun areItemsTheSame(oldItem: NewHeadLine, newItem: NewHeadLine): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NewHeadLine, newItem: NewHeadLine): Boolean {
        return oldItem.source?.id == newItem.source?.id
    }

}