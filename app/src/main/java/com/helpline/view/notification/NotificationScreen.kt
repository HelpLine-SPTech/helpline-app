package com.example.helpline.View.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helpline.R
import com.example.helpline.ui.app.Componente.Notification.Header.HeaderNotification
import com.example.helpline.ui.app.Componente.Notification.NotificationItem

val poppinsFamily = FontFamily(
  Font(R.font.poppins_regular, FontWeight.Normal),
  Font(R.font.poppins_bold, FontWeight.Bold),
  Font(R.font.poppins_medium, FontWeight.Medium),
  Font(R.font.poppins_semibold, FontWeight.SemiBold),
  Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)


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
      fontFamily = poppinsFamily,
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
      fontFamily = poppinsFamily,
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
      fontFamily = poppinsFamily,
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