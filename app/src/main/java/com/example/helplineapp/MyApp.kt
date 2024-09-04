package com.example.helplineapp

import android.app.Application

class MyApp: Application() {

  companion object{
    lateinit var context: Application
      private set
  }

  override fun onCreate() {
    super.onCreate()
    context = this.applicationContext.applicationContext as Application
  }
}