package com.preeti.assignment
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UserApplication: Application() {
    private val LOG_TAG = "StackOverflowUserApplication"
    companion object {
        lateinit var instance: UserApplication
     //   lateinit var resources: Resources

    }
    override fun onCreate() {
        super.onCreate()
        instance  = this
    }
}


