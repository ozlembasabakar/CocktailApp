package com.example.cocktailapp

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@AndroidEntryPoint
class FirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {

        super.onMessageReceived(message)

        showNotification(message = message)

        //Incoming Message
        Log.v("CloudMessage", "From ${message.from}")

        //Data Payload
        if (message.data.isEmpty()) {
            Log.v("CloudMessage", "Message Data ${message.data}")
        }

        //If message contains a notification payload
        message.data.let {
            Log.v("CloudMessage", "Message Notification Body ${it["body"]}")
        }

        if (message.notification != null) {
            Log.v("CloudMessage", "Message Notification ${message.notification}")
            Log.v("CloudMessage", "Message Notification Title ${message.notification!!.title}")
            Log.v("CloudMessage", "Message Notification Body ${message.notification!!.body}")
        }
    }

    private fun showNotification(message: RemoteMessage) {
        val CHANNEL_ID = "COCKTAIL_APP"

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(message.notification!!.title)
            .setContentText(message.notification!!.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(Random.nextInt(), builder.build())
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        GlobalScope.launch {
            saveGCMToken(token)
        }
    }

    //Save GCMToken DataStore Preference
    private suspend fun saveGCMToken(token: String) {
        val gckToken = stringPreferencesKey("gcm_token")
        baseContext.dataStore.edit { preferences ->
            preferences[gckToken] = token
        }

    }
}