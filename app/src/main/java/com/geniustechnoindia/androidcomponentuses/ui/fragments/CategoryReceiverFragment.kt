package com.geniustechnoindia.androidcomponentuses.ui.fragments

import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geniustechnoindia.androidcomponentuses.Receiver.BluetoothStateReceiver
import com.geniustechnoindia.androidcomponentuses.databinding.FragmentCategoryReceiverBinding
import com.sunitawebapp.locationonmap.adapter.TopicAdapter


class CategoryReceiverFragment : Fragment() {
   lateinit var binding : FragmentCategoryReceiverBinding
    lateinit  var topicAdapter : TopicAdapter

     var mBroadcastReceiver3 : BluetoothStateReceiver =BluetoothStateReceiver()
    var topiclist : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val filter3 = IntentFilter()
        filter3.addAction(BluetoothDevice.ACTION_ACL_CONNECTED)
        filter3.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED)

        requireActivity().registerReceiver(mBroadcastReceiver3, filter3);
        requireActivity().sendBroadcast( Intent(requireContext(), BluetoothStateReceiver::class.java));
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCategoryReceiverBinding.inflate(inflater, container, false)
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
        topiclist.add("Bluetooth Pair")
        topiclist.add("Wifi & Internet States")
    }
}