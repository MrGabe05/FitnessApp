package com.gabrielhd.fitnessapp.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContextWrapper
import com.gabrielhd.fitnessapp.helper.PrefsHelper

class App : android.app.Application() {

    override fun onCreate() {
        super.onCreate()

        PrefsHelper.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            "CHANNEL_ID",
            "Contact Tracing Service",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = getSystemService(
            NotificationManager::class.java
        )
        manager.createNotificationChannel(serviceChannel)
    }
}