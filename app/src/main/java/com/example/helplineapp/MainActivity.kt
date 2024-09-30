package com.example.helplineapp

import CadastroScreen
import CadastroViewModel
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.GetContext.Companion.context
import com.example.helplineapp.View.Cadastro.CadastroScreen
import com.example.helplineapp.View.Chat1.ConversasScreen
import com.example.helplineapp.View.Forum.ForumScreen
import com.example.helplineapp.View.Login.LoginScreen
import com.example.helplineapp.ui.theme.HelplineAppTheme
import com.example.helplineapp.View.Login.LoginScreen
import com.example.helplineapp.View.SplashScreen.SplashScreen

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
        NavHost(navController = navController, startDestination = "splashScreen") {

          // Criando a rota para a tela de login
          composable(route = "loginPage") {
            val loginViewModel: LoginViewModel = koinViewModel()
            LoginScreen(navController, loginViewModel)
          }

          // Rota para tela do fórum
          composable(route = "forumScreen") {
            ForumScreen(navController)
          }

          // Rota para tela de splash screen
          composable(route = "splashScreen") {
            SplashScreen(navController)
          }

          composable(route = "signinStep1") {
            CadastroScreen(CadastroViewModel(), navController)
          }

          composable(route = "chat-list") {
            ConversasScreen()
          }
        }
      }
    }
  }
}