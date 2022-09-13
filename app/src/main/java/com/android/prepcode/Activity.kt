package com.android.prepcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity : AppCompatActivity() {

    override fun onStart() {
        Log.e("ActivityLifecycle","onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.e("ActivityLifecycle","onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.e("ActivityLifecycle","onResume")
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("ActivityLifecycle","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
    }

    override fun onPause() {
        Log.e("ActivityLifecycle","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("ActivityLifecycle","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("ActivityLifecycle","onDestroy")
        super.onDestroy()
    }
}