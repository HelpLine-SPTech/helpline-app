package com.helpline

import android.app.Application
import com.helpline.config.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.PrintLogger

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidContext(this@App)
      logger(PrintLogger(Level.DEBUG))
      modules(appModule)
    }
  }
}