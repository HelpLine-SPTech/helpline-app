package com.example.helplineapp.view.Login

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helplineapp.R
import com.example.helplineapp.ViewModel.Login.LoginViewModel


@Composable
fun LoginScreen(navController: NavController) {
  val context = LocalContext.current
  val viewModel: LoginViewModel = LoginViewModel()

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFFAF9F7))
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

      Spacer(modifier = Modifier.height(44.dp))

      Text(
        text = "Por favor faça login em sua conta.",
        color = Color(0xFF1C4532),
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(28.dp))

      LoginForm(navController)

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = "Não possui conta? Cadastre-se",
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = Color.Black
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(navController: NavController) {
  val context = LocalContext.current
  var email by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }

  BackHandler {}

  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    Text(
      text = "Email",
      color = Color(0xFF9CA3AF),
    )

    TextField(
      value = email,
      onValueChange = { email = it },
      colors = TextFieldDefaults.textFieldColors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        containerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
      ),
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clip(RoundedCornerShape(24.dp))
        .background(Color.Yellow)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      text = "Senha",
      color = Color(0xFF9CA3AF),
    )

    TextField(
      value = password,
      onValueChange = { password = it },
      visualTransformation = PasswordVisualTransformation(),
      colors = TextFieldDefaults.textFieldColors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        containerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
      ),
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clip(RoundedCornerShape(24.dp))
        .background(Color.White),
    )

    Text(
      text = "Esqueceu sua senha?",
      fontSize = 12.sp,
      color = Color(0xFF9CA3AF),
      modifier = Modifier.padding(start = 12.dp, top = 14.dp)
    )

    Spacer(modifier = Modifier.height(48.dp))

    Button(
      onClick = {
        if (email == "admin@teste.com" && password == "admin123") {
          Toast.makeText(context, "Login realizado com sucesso!", Toast.LENGTH_LONG).show()
          navController.navigate("forumScreen") {
            popUpTo("loginPage") { inclusive = true }
          }
        } else {
          Toast.makeText(context, "Email ou senha incorretos", Toast.LENGTH_LONG).show()
        }
      },
      modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .clip(RoundedCornerShape(24.dp)),
      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1C4532))
    ) {
      Text(
        text = "Entrar",
        color = Color.White,
        fontWeight = FontWeight.Bold
      )
    }
  }
}