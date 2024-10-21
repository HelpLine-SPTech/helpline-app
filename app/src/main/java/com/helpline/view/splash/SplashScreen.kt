package com.helpline.view.splash

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helpline.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

  BackHandler {}

  //Controla o tempo de exibição da splash screen (2 segundos neste caso)
  LaunchedEffect(key1 = true) {
    delay(2000)
    navController.navigate("loginPage") {
      // Remove a splash screen da pilha para que o usuário não possa voltar a ela
      popUpTo("splashScreen") { inclusive = true }
    }
  }

  // Layout da Splash Screen
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFFAF9F7)),
    contentAlignment = Alignment.Center

  ) {
    Image(
      painter = painterResource(id = R.drawable.background_image),
      contentDescription = null,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop
    )

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 48.dp, vertical = 44.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        modifier = Modifier
          .width(163.dp)
          .aspectRatio(1.43f)
      )
    }
  }
}