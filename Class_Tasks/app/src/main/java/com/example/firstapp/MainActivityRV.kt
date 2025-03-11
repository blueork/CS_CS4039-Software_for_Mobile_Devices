package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityRV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_rv)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        var rv=findViewById<RecyclerView>(R.id.rv)
        var add=findViewById<RelativeLayout>(R.id.add)
        var list= mutableListOf<Model>()
//        list.add(Model("Jhon Doe","0992","jhon.doe@gmail.com"))
//        list.add(Model("Will Smith","2990","will.smith@gmail.com"))
//        list.add(Model("Jada Smith","1122","jada.smith@gmail.com"))

        var adapter=MyAdapter(list,this)
        var lm= LinearLayoutManager(this)
        rv.layoutManager=lm
        rv.adapter=adapter

        var result =registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode== RESULT_OK) {
                var dataa=it.data

                var name = dataa?.getStringExtra("name")
                Log.d("name", name!!)
                var rollnum = dataa?.getStringExtra("rollnum")
                Log.d("rollnum",rollnum!!)
                var email = dataa?.getStringExtra("email")
                Log.d("email",email!!)
                var image = dataa?.getStringExtra("image")
                list.add(Model(name!!,rollnum!!,email!!,image!!))
                adapter.notifyDataSetChanged()
            }
        }

        add.setOnClickListener {
            var intent= Intent(this,AddContact::class.java)
            result.launch(intent)
        }

    }
}