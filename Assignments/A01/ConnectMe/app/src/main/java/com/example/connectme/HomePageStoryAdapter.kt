package com.example.connectme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomePageStoryAdapter(private val storyPicList : ArrayList<HomePageStoryModel>) : RecyclerView.Adapter<HomePageStoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageStoryAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_page_story_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomePageStoryAdapter.MyViewHolder, position: Int) {
        val currentItem = storyPicList[position]
        holder.storyPic.setImageResource(currentItem.storyPic)
    }

    override fun getItemCount(): Int {
        return storyPicList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val storyPic = itemView.findViewById<ImageView>(R.id.story_pic)
    }

}