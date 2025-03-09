package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class AddContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_contact)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        var name= findViewById<EditText>(R.id.name)
        var rollnum= findViewById<EditText>(R.id.rollnum)
        var email= findViewById<EditText>(R.id.email)
        var dp= findViewById<CircleImageView>(R.id.dp)

        var save= findViewById<Button>(R.id.save)

        save.setOnClickListener {
            var data= Intent()
            data.putExtra("name",name.text.toString())
            data.putExtra("rollnum",rollnum.text.toString())
            data.putExtra("email",email.text.toString())
            setResult(Activity.RESULT_OK,data)
            finish()

        }
        var result =registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            dp.setImageURI(it.data?.data)
        }

        dp.setOnClickListener {
            var int= Intent()
            int.setAction(Intent.ACTION_VIEW)
            int.setType("image/*")
            result.launch(int)
        }
    }
}