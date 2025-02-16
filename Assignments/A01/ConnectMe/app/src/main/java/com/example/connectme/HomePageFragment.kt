package com.example.connectme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var homePagePostRecyclerView : RecyclerView
    private lateinit var homePagePostArrayList : ArrayList<HomePagePostModel>
    private lateinit var homePagePostAdapter: HomePagePostAdapter

    lateinit var homePagePostImageId : Array<Int>
    lateinit var homePagePostProfilePicImageId : Array<Int>
    lateinit var homePagePostProfileName : Array<String>
    lateinit var homePagePostDesc : Array<String>

    private lateinit var homePageStoryRecyclerView: RecyclerView
    private lateinit var homePageStoryArrayList : ArrayList<HomePageStoryModel>
    private lateinit var homePageStoryAdapter: HomePageStoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        homePagePostRecyclerView = view.findViewById(R.id.home_page_post_recyclerView)
        homePagePostRecyclerView.layoutManager = layoutManager
        homePagePostRecyclerView.setHasFixedSize(true)
        homePagePostAdapter = HomePagePostAdapter(homePagePostArrayList)
        homePagePostRecyclerView.adapter = homePagePostAdapter

        homePageStoryRecyclerView = view.findViewById(R.id.home_page_story_recyclerView)
        homePageStoryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homePagePostRecyclerView.setHasFixedSize(true)
        homePageStoryAdapter = HomePageStoryAdapter(homePageStoryArrayList)
        homePageStoryRecyclerView.adapter = homePageStoryAdapter
    }

    private fun dataInitialize() {
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
        homePagePostArrayList = arrayListOf<HomePagePostModel>()

        for(i in homePagePostImageId.indices) {
            val homePagePostModel = HomePagePostModel(homePagePostProfileName[i], homePagePostDesc[i], homePagePostProfilePicImageId[i], homePagePostImageId[i])
            homePagePostArrayList.add(homePagePostModel)
        }

        homePageStoryArrayList = arrayListOf<HomePageStoryModel>()

        for(i in homePagePostProfilePicImageId.indices) {
            val homePageStoryModel = HomePageStoryModel(homePagePostProfilePicImageId[i])
            homePageStoryArrayList.add(homePageStoryModel)
        }

    }

}