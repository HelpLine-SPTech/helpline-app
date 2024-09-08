package com.example.helplineapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.View.Forum.ForumScreen
import com.example.helplineapp.View.Login.LoginScreen
import com.example.helplineapp.ui.theme.HelplineAppTheme

class MainActivity : ComponentActivity() {
  @SuppressLint("WrongConstant")
  @RequiresApi(Build.VERSION_CODES.R)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    WindowInsetsControllerCompat(window, window.decorView).let { controller ->
      controller.hide(android.view.WindowInsets.Type.systemBars())
      controller.systemBarsBehavior =
        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
    setContent {
      HelplineAppTheme {
        val navController = rememberNavController()
        // startDestination -> Tela que o aplicativo vai começar
        NavHost(navController = navController, startDestination = "loginPage") {

          // Criando a rota para a tela de login
          composable(route = "loginPage") {
            LoginScreen(navController)
          }

          composable(route = "forumScreen") {
            ForumScreen(navController)
          }
        }
      }
    }
  }
}