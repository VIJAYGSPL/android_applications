package com.example.vijay.firebasecloudmessaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val senderID = "YOUR_SENDER_ID"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getToken()
    }
//    private fun getToken() {
//
//        Thread(Runnable {
//            try {
//
//                val newToken = FirebaseInstanceId.getInstance()
//                    .getToken(senderID, "FCM")
//                println("Token --> $newToken")
//
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }).start()
//    }

}