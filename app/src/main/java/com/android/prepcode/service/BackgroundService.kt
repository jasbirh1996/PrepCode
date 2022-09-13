package com.android.prepcode.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.lifecycle.MutableLiveData
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.android.prepcode.utils.Constants
import kotlinx.coroutines.*


class BackgroundService : Service() {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    companion object {
        private val _counterState : MutableLiveData<String> = MutableLiveData()
        val counterState = _counterState
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        _counterState.postValue("Service Started")
        var counter = 10
        scope.launch {
            while (counter> 0) {
                delay(1000)
                _counterState.postValue(counter.toString())
                counter--
            }
            stopSelf()
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        _counterState.postValue("Service Stopped")
    }
}