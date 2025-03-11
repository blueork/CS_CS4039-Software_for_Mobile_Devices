package com.example.firstapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

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
        holder.dp.setImageBitmap(base64ToBitmap(list[position].img ))

        holder.row.setOnClickListener {
            var intent= Intent(c,ViewContact::class.java)
            intent.putExtra("name",list[position].name)
            intent.putExtra("email",list[position].email)
            intent.putExtra("rollnum",list[position].rollnum)
            intent.putExtra("image",list[position].img)
            c.startActivity(intent)

        }
        holder.row.setOnLongClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
            true
        }
    }

    fun base64ToBitmap(base64String: String): Bitmap? {
        return try {
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name=itemView.findViewById(R.id.name) as TextView
        var rollnum=itemView.findViewById(R.id.rollnum) as TextView
        var email=itemView.findViewById(R.id.email) as TextView
        var dp=itemView.findViewById(R.id.dp) as CircleImageView
        var row=itemView.findViewById(R.id.row) as LinearLayout
    }

}