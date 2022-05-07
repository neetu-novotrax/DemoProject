package com.example.praticaldemo

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
       // AppDatabase.getAppDatabase(this);
    }
}