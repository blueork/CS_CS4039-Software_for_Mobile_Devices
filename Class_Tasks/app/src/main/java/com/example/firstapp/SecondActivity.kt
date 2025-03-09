package com.example.firstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
//        var tv=findViewById<TextView>(R.id.tv)
//        var msg=intent.getStringExtra("msg")
//        Toast.makeText(
//            this,
//            msg.toString(),
//            Toast.LENGTH_LONG
//        ).show()
//        tv.setText(msg)
    }
}