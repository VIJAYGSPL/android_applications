package com.example.vijay.firebasecloudmessaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
            Log.d("FCM Token", token)
        }.addOnFailureListener { failure ->
            Log.e("FCM Token", "Failed to get FCM token: $failure")
        }
    }


}