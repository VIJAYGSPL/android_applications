package com.example.vijay.firebasecloudmessaging

import android.Manifest
import android.R
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class FirebaseMessageReceiver : FirebaseMessagingService() {


    private val TAG = "FirebaseMessagingService"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        val CHANNEL_ID = "HEADS_UP_NOTIFICATION"
        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            "Heads Up Notification",
            NotificationManager.IMPORTANCE_HIGH
        )

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        val notificationBuilder = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle(remoteMessage.notification?.title)
            .setContentText(remoteMessage.notification?.body)
            .setSmallIcon(R.drawable.sym_def_app_icon)
            .setAutoCancel(true)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        NotificationManagerCompat.from(this).notify(1, notificationBuilder.build())
        super.onMessageReceived(remoteMessage)

    }
}