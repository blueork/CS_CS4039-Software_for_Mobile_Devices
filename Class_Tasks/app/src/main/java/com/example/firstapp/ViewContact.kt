package com.example.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_contact)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        var name=findViewById<TextView>(R.id.name)
        var rollnum=findViewById<TextView>(R.id.rollnum)
        var email=findViewById<TextView>(R.id.email)

        name.setText(intent.getStringExtra("name"))
        rollnum.setText(intent.getStringExtra("rollnum"))
        email.setText(intent.getStringExtra("email"))
    }
}