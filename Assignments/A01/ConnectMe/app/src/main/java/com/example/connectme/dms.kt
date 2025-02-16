package com.example.connectme

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class dms : AppCompatActivity() {
    private lateinit var dmRecyclerView : RecyclerView
    private lateinit var dmArrayList : ArrayList<DM_Model>

    lateinit var profilePicImageId : Array<Int>
    lateinit var chatPersonName : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dms)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profilePicImageId = arrayOf(
            R.drawable.person_pic_1,
            R.drawable.person_pic_2,
            R.drawable.person_pic_3,
            R.drawable.person_pic_4,
            R.drawable.person_pic_5,
            R.drawable.person_pic_6
        )

        chatPersonName = resources.getStringArray(R.array.chat_person_name_txt)

        dmRecyclerView = findViewById(R.id.dmRecyclerView)
        dmRecyclerView.layoutManager = LinearLayoutManager(this)

        dmArrayList = arrayListOf<DM_Model>()
        getUserData()

    }

    private fun getUserData() {
        for(i in profilePicImageId.indices) {
            val dm_Model = DM_Model(profilePicImageId[i], chatPersonName[i])
            dmArrayList.add(dm_Model)
        }

        dmRecyclerView.adapter = DM_Adapter(dmArrayList)
    }

}

