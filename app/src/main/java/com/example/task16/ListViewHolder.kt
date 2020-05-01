package com.example.task16

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val tvTitle: TextView = itemView.tvTitle
    private val tvDescription: TextView = itemView.tvDescription

    fun populateModel(user: User, size: Int, position: Int, activity: MainActivity){
        tvTitle.text=user.title
        tvDescription.text=user.description
        itemView.btnOptions.setOnClickListener{
            activity.onOptionsButtonClick(itemView.btnOptions,position)
        }
    }
}