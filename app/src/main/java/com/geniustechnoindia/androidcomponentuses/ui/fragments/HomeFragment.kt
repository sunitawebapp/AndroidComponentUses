package com.geniustechnoindia.androidcomponentuses.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geniustechnoindia.androidcomponentuses.R
import com.geniustechnoindia.androidcomponentuses.databinding.FragmentHomeBinding
import com.sunitawebapp.locationonmap.adapter.TopicAdapter


class HomeFragment : Fragment() {
   lateinit var binding : FragmentHomeBinding
    lateinit  var topicAdapter : TopicAdapter
    var topiclist : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getTopicList()
        topicAdapter = TopicAdapter(topiclist)

        binding.rvTopicList.adapter=topicAdapter

        topicAdapter.setOnItemClickListener(object :TopicAdapter.OnClickRecyclerView{
            override fun setOnClickRecyclerView(position: Int) {
                if(position==1){
                    findNavController().navigate(R.id.categoryServiceFragment)
                }
                if(position==2){
                    findNavController().navigate(R.id.categoryReceiverFragment)
                }
                if(position==3){
                    findNavController().navigate(R.id.categoryProviderFragment)
                }
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    fun getTopicList(){
        topiclist.clear()
        topiclist.add("Activity")
        topiclist.add("Service")
        topiclist.add("Broadcast Receiver")
        topiclist.add("Content Provider")
    }

}