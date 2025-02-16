package com.example.connectme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DM_Adapter(private val dmList : ArrayList<DM_Model>) : RecyclerView.Adapter<DM_Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dms_layout, parent, false)
        return DM_Adapter.MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dmList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dmList[position]
        holder.chatPersonName.text = currentItem.chatPersonName
        holder.profilePic.setImageResource(currentItem.profilePic)
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val chatPersonName = itemView.findViewById<TextView>(R.id.chatPersonName)
        val profilePic = itemView.findViewById<ImageView>(R.id.profile_pic)
    }
}