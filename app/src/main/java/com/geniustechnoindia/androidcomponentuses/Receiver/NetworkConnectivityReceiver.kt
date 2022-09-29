package com.geniustechnoindia.androidcomponentuses.Receiver
//https://protocoderspoint.com/how-to-check-internet-connection-in-android/

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast


class NetworkConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      //  val status: String = NetworkUtil.getConnectivityStatusString(context)
        val status: String? = getConnectivityStatusString(context)
        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }

    fun getConnectivityStatusString(context: Context?): String? {
        var status: String? = null
        val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                status = "Wifi enabled"
                return status
            } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                status = "Mobile data enabled"
                return status
            }
        } else {
            status = "No internet is available"
            return status
        }
        return status
    }
}