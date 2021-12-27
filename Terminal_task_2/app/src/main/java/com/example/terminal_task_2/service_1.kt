package com.example.terminal_task_2

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class service_1 : Service() {
    val Tag="Service"
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

       Toast.makeText(this,"I am started",Toast.LENGTH_LONG).show()
        Log.d(Tag, "I am started")

        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"I am destroyed",Toast.LENGTH_LONG).show()
        Log.d(Tag, "I am Destroyed")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}