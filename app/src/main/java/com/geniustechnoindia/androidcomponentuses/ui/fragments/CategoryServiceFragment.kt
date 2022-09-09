package com.geniustechnoindia.androidcomponentuses.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geniustechnoindia.androidcomponentuses.R
import com.geniustechnoindia.androidcomponentuses.databinding.FragmentCategoryServiceBinding
import com.sunitawebapp.locationonmap.adapter.TopicAdapter


class CategoryServiceFragment : Fragment() {
lateinit var binding :FragmentCategoryServiceBinding
    lateinit  var topicAdapter : TopicAdapter
    var topiclist : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCategoryServiceBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getTopicList()
        topicAdapter = TopicAdapter(topiclist)

        binding.rvTopicList.adapter=topicAdapter
        super.onViewCreated(view, savedInstanceState)
    }

    fun getTopicList(){
        topiclist.add("Time Counting")
        topiclist.add("Alarm")
    }
}