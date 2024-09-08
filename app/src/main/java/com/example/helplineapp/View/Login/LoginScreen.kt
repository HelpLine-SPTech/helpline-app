package com.example.helplineapp.View.Login

import android.widget.Toast
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

      LoginForm(navController, viewModel)

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
fun LoginForm(navController: NavController, viewModel: LoginViewModel) {
  val context = LocalContext.current

  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    Text(
      text = "Email",
      color = Color(0xFF9CA3AF),
    )

    TextField(
      value = viewModel.userEmail,
      onValueChange = {viewModel.onEmailChange(it)},
      colors = TextFieldDefaults.textFieldColors(
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
      value = viewModel.userPassword,
      onValueChange = { viewModel.onPasswordChange(it) },
      visualTransformation = PasswordVisualTransformation(),
      colors = TextFieldDefaults.textFieldColors(
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
        viewModel.loginUser(
          onLoginSuccess = {
            Toast.makeText(context, "Login realizado com sucesso!", Toast.LENGTH_LONG).show()

          },
          onLoginError = { errorMessage ->
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
          }
        )
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