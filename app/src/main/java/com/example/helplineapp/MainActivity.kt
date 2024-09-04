package com.example.helplineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.ui.theme.HelplineAppTheme
import com.example.myfirstproject.View.Login.LoginScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HelplineAppTheme {
        val navController = rememberNavController()

        // startDestination -> Tela que o aplicativo vai começar
        NavHost(navController = navController, startDestination = "loginPage") {

          // Criando a rota para a tela de login
          composable(route = "loginPage") {
            LoginScreen(navController)
          }
        }
      }
    }
  }

//  @Preview(showBackground = true)
//  @Composable
//  fun GreetingPreview() {
//    HelplineAppTheme {
//
//    }
//  }
}