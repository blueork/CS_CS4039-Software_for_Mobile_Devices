package com.example.connectme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePage : AppCompatActivity() {
    private lateinit var homePagePostRecyclerView : RecyclerView
    private lateinit var homePagePostArrayList : ArrayList<HomePagePostModel>
    lateinit var homePagePostImageId : Array<Int>
    lateinit var homePagePostProfilePicImageId : Array<Int>
    lateinit var homePagePostProfileName : Array<String>
    lateinit var homePagePostDesc : Array<String>

    private lateinit var homePageStoryRecyclerView: RecyclerView
    private lateinit var homePageStoryArrayList : ArrayList<HomePageStoryModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dmButton = findViewById<Button>(R.id.dm_button)
        dmButton.setOnClickListener{
            val intent = Intent(this, dms::class.java)
            startActivity(intent)
        }

        homePagePostImageId = arrayOf(
            R.drawable.post_pic_1,
            R.drawable.post_pic_2,
            R.drawable.post_pic_3,
            R.drawable.post_pic_4,
            R.drawable.post_pic_5,
            R.drawable.post_pic_6
        )
        homePagePostProfilePicImageId = arrayOf(
            R.drawable.person_pic_1,
            R.drawable.person_pic_2,
            R.drawable.person_pic_3,
            R.drawable.person_pic_4,
            R.drawable.person_pic_5,
            R.drawable.person_pic_6
        )

        homePagePostProfileName = resources.getStringArray(R.array.home_page_post_profile_names_txt)
        homePagePostDesc = resources.getStringArray(R.array.home_page_post_profile_desc_txt)

        homePagePostRecyclerView = findViewById(R.id.home_page_post_recyclerView)
        homePagePostRecyclerView.layoutManager = LinearLayoutManager(this)
        // homePagePostRecyclerView.setHasFixedSize(true)

        homePagePostArrayList = arrayListOf<HomePagePostModel>()
        getUserData()

        homePageStoryRecyclerView = findViewById(R.id.home_page_story_recyclerView)
        homePageStoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        homePageStoryRecyclerView.setHasFixedSize(true)
        homePageStoryArrayList = arrayListOf<HomePageStoryModel>()
        getStoryUserData()

    }

    private fun getUserData() {
        for(i in homePagePostImageId.indices) {
            val homePagePostModel = HomePagePostModel(homePagePostProfileName[i], homePagePostDesc[i], homePagePostProfilePicImageId[i], homePagePostImageId[i])
            homePagePostArrayList.add(homePagePostModel)
        }
        homePagePostRecyclerView.adapter = HomePagePostAdapter(homePagePostArrayList)
    }

    private fun getStoryUserData() {
        for(i in homePagePostProfilePicImageId.indices) {
            val homePageStoryModel = HomePageStoryModel(homePagePostProfilePicImageId[i])
            homePageStoryArrayList.add(homePageStoryModel)
        }
        homePageStoryRecyclerView.adapter = HomePageStoryAdapter(homePageStoryArrayList)
    }

}