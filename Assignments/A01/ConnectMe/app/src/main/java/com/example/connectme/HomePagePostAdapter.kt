package com.example.connectme

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomePagePostAdapter(private val postList : ArrayList<HomePagePostModel>) : RecyclerView.Adapter<HomePagePostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePagePostAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_page_post_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomePagePostAdapter.MyViewHolder, position: Int) {
        val currentItem = postList[position]
        holder.profileName.text = currentItem.profileName
        holder.profilePic.setImageResource(currentItem.profilePic)
        holder.postDesc.text = currentItem.postDesc
        holder.postPic.setImageResource(currentItem.postPic)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val profileName = itemView.findViewById<TextView>(R.id.profile_name)
        val profilePic = itemView.findViewById<ImageView>(R.id.profile_pic)
        val postDesc = itemView.findViewById<TextView>(R.id.post_description)
        val postPic = itemView.findViewById<ImageView>(R.id.post_picture)
    }

}