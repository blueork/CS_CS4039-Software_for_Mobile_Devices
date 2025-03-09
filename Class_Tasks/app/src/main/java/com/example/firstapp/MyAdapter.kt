package com.example.firstapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: MutableList<Model>, val c: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text=list[position].name
        holder.rollnum.text=list[position].rollnum
        holder.email.text=list[position].email
        holder.row.setOnClickListener {
            var intent= Intent(c,ViewContact::class.java)
            intent.putExtra("name",list[position].name)
            intent.putExtra("email",list[position].email)
            intent.putExtra("rollnum",list[position].rollnum)
            c.startActivity(intent)

        }
        holder.row.setOnLongClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
            true
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name=itemView.findViewById(R.id.name) as TextView
        var rollnum=itemView.findViewById(R.id.rollnum) as TextView
        var email=itemView.findViewById(R.id.email) as TextView
        var row=itemView.findViewById(R.id.row) as LinearLayout
    }

}