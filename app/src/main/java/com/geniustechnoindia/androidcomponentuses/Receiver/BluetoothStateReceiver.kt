package com.geniustechnoindia.androidcomponentuses.Receiver

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothDevice.ACTION_ACL_CONNECTED
import android.bluetooth.BluetoothDevice.ACTION_ACL_DISCONNECTED
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BluetoothStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       val action=intent!!.action
      //  if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
        //    var state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

            when(action) {
                BluetoothDevice.ACTION_ACL_CONNECTED->{
                     Toast.makeText(context,"state Connect",Toast.LENGTH_SHORT).show()
                 }
                BluetoothDevice.ACTION_ACL_DISCONNECTED->{
                     Toast.makeText(context,"state DisConnect",Toast.LENGTH_SHORT).show()
                 }

          //  }
        }

    }
}