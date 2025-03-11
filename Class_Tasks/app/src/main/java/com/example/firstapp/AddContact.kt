package com.example.firstapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView
import java.io.ByteArrayOutputStream

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
        var image: Bitmap? = null
        var save= findViewById<Button>(R.id.save)

        save.setOnClickListener {
            var data= Intent()
            data.putExtra("name",name.text.toString())
            data.putExtra("rollnum",rollnum.text.toString())
            data.putExtra("email",email.text.toString())
            data.putExtra("image",bitmapToBase64(image!!).toString())
            setResult(Activity.RESULT_OK,data)
            finish()

        }

        var result =registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            image= it.data?.data?.let { it1 -> uriToBitmap(this, it1) }!!
            dp.setImageBitmap(image)
//            dp.setImageURI(it.data?.data)
        }

        dp.setOnClickListener {
            var int= Intent()
//            int.setAction(Intent.ACTION_VIEW)
            int.setAction(Intent.ACTION_PICK)
            int.setType("image/*")
            result.launch(int)
        }
    }

    fun bitmapToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 5, byteArrayOutputStream) // You can use JPEG too
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    fun uriToBitmap(context: Context, uri: Uri): Bitmap? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}