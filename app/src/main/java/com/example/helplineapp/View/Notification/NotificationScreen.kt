package com.example.helplineapp.View.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helplineapp.R
import com.example.helplineapp.ui.theme.Componente.Notification.NotificationItem


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
    Header(navController)
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
      image = R.mipmap.fotomaria,
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
      image = R.mipmap.profile_noemi,
      name = "Maria Eduarda",
      action = "curtiu sua publicação"
    )
    NotificationItem(
      image = R.mipmap.profile_noemi,
      name = "Maria Eduarda",
      action = "curtiu sua publicação"
    )
  }
}

@Composable
fun Header(navController: NavController) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Button(
        onClick = {
          navController.navigate("forumScreen")
        },
        modifier = Modifier.padding(end = 8.dp)
          .size(80.dp)
          .width(90.dp),

        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
          .copy(contentColor = Color.Black)
      ) {
        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
      }
      Spacer(modifier = Modifier.width(35.dp))
      Text(
        text = "Notificações",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
      )
      Spacer(modifier = Modifier.width(17.dp))
    }
    Image(
      painter = painterResource(id = R.mipmap.img_julia_almeida),
      contentDescription = "Profile Icon",
      modifier = Modifier.size(56.dp)
    )
  }
}
