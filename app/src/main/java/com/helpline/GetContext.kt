package com.helpline

import android.app.Application

class GetContext : Application() {

  companion object {
    lateinit var context: Application
      private set
  }

  override fun onCreate() {
    super.onCreate()
    context = this.applicationContext.applicationContext as Application
  }
}