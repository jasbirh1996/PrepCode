package com.android.prepcode

import android.content.BroadcastReceiver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.prepcode.databinding.ActivityMainBinding
import com.android.prepcode.service.BackgroundService
import kotlinx.coroutines.channels.BroadcastChannel


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding




    override fun onStart() {
        Log.e("ActivityLifecycle1", "onStart")
        super.onStart()


    }

    override fun onRestart() {
        Log.e("ActivityLifecycle1", "onRestart")
        super.onRestart()


    }


    override fun onResume() {
        Log.e("ActivityLifecycle1", "onResume")
        super.onResume()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("ActivityLifecycle1", "onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this,BackgroundService::class.java)

        binding.apply {
            btStart.setOnClickListener {
                startService(intent)
                observeService()

            }
            btStop.setOnClickListener {
                stopService(intent)
            }
            button.setOnClickListener {
                startActivity(Intent(this@MainActivity,Activity::class.java))
            }

        }
    }



   private fun observeService(){
    val observer =  BackgroundService.counterState.observe(this){

            if(it != null){
                binding.apply {
                    tvState.setText(it)
                }
            }



        }


    }

    override fun onPause() {
        Log.e("ActivityLifecycle1", "onPause")
        super.onPause()


    }

    override fun onStop() {
        Log.e("ActivityLifecycle1", "onStop")
        super.onStop()


    }


    override fun onDestroy() {
        Log.e("ActivityLifecycle1", "onDestroy")
        super.onDestroy()

    }


}