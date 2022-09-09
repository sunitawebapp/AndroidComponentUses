package com.geniustechnoindia.androidcomponentuses.Receiver

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BluetoothStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       val action=intent!!.action
      //  if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
        //    var state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

        if (action != null && action == BluetoothAdapter.ACTION_STATE_CHANGED) {
            val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)

                when (state) {
                    BluetoothAdapter.STATE_OFF -> Toast.makeText(context,"STATE_OFF",Toast.LENGTH_SHORT).show()
                    BluetoothAdapter.STATE_TURNING_OFF -> Toast.makeText(context,"STATE_TURNING_OFF",Toast.LENGTH_SHORT).show()
                    BluetoothAdapter.STATE_ON ->Toast.makeText(context,"STATE_ON",Toast.LENGTH_SHORT).show()
                    BluetoothAdapter.STATE_TURNING_ON -> Toast.makeText(context,"STATE_TURNING_ON",Toast.LENGTH_SHORT).show()
                }

        }

    }
}