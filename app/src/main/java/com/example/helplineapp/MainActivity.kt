package com.example.helplineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.GetContext.Companion.context
import com.example.helplineapp.View.Forum.PostCard
import com.example.helplineapp.ui.theme.HelplineAppTheme


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HelplineAppTheme {

        PostCard(navController = NavController(context))
        val navController = rememberNavController()

        // startDestination -> Tela que o aplicativo vai começar
        NavHost(navController = navController, startDestination = "loginPage") {

          // Criando a rota para a tela de login
          composable(route = "loginPage") {
            PostCard(navController)
          }
        }
      }
    }
  }
}