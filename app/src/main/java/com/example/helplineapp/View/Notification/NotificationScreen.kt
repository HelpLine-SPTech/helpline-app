package com.example.helplineapp.view.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helplineapp.R
import com.example.helplineapp.ui.app.Componente.Notification.Header.HeaderNotification
import com.example.helplineapp.ui.app.Componente.Notification.NotificationItem


@Composable
fun NotificationScreen(navController: NavController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
      .padding(horizontal = 20.dp, vertical = 31.dp)
      .clip(RoundedCornerShape(25.dp))
      .verticalScroll(rememberScrollState())
  ) {
    HeaderNotification(navController)
    Spacer(modifier = Modifier.height(23.dp))
    Text(
      text = "Hoje",
      fontSize = 16.sp,
      fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(7.dp))
    NotificationItem(
      image = R.mipmap.profile_maria_medeiros,
      name = "Maria Medeiros",
      action = "curtiu sua publicação"
    )
    NotificationItem(
      image = R.mipmap.profile_yoshi,
      name = "José Yoshiro",
      action = "curtiu sua publicação"
    )
    Spacer(modifier = Modifier.height(14.dp))
    Text(
      text = "Ontem",
      fontSize = 16.sp,
      fontWeight = FontWeight.SemiBold
    )
    NotificationItem(
      image = R.drawable.profile_maria_eduarda,
      name = "Maria Eduarda",
      action = "curtiu sua publicação"
    )
    NotificationItem(
      image = R.mipmap.img_julia_almeida,
      name = "Maria Eduarda",
      action = "curtiu sua publicação"
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
      text = "Semana Passada",
      fontSize = 16.sp,
      fontWeight = FontWeight.SemiBold
    )
    NotificationItem(
      image = R.mipmap.profile_noemi_santos,
      name = "Maria Eduarda",
      action = "curtiu sua publicação"
    )
    NotificationItem(
      image = R.mipmap.profile_noemi_santos,
      name = "Maria Eduarda",
      action = "curtiu sua publicação"
    )
  }
}