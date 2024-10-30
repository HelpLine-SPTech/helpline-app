package com.helpline.ui.app.componente.notification.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.helpline.R

@Composable
fun HeaderNotification(navController: NavController) {
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
      painter = painterResource(id = R.mipmap.imgperfil),
      contentDescription = "Profile Icon",
      modifier = Modifier
        .size(50.dp)
        .clip(CircleShape)
        .border(2.dp, Color.Gray, CircleShape)
    )
  }
}