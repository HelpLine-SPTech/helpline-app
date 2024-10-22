package com.helpline

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.helpline.view.campanha.CampanhaScreen
import com.helpline.view.chat1.ConversasScreen
import com.helpline.view.forum.ForumScreen
import com.helpline.view.splash.SplashScreen
import com.helpline.ui.app.HelplineAppTheme
import com.helpline.view.login.LoginScreen
import com.helpline.viewmodel.login.LoginViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
  @SuppressLint("WrongConstant")
  @RequiresApi(Build.VERSION_CODES.R)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    WindowInsetsControllerCompat(window, window.decorView).let { controller ->
      controller.hide(WindowInsets.Type.systemBars())
      controller.systemBarsBehavior =
        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
    setContent {
      HelplineAppTheme {
        val navController = rememberNavController()
        // startDestination -> Tela que o aplicativo vai começar
        NavHost(navController = navController, startDestination = "loginPage" /*"splashScreen"*/) {

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

     //       CadastroScreen(CadastroViewModel(), navController)

          }

          composable(route = "chat-list") {
            ConversasScreen()
          }

          composable(route = "tela-campanha"){
            CampanhaScreen(navController)
          }
        }
      }
    }
  }
}