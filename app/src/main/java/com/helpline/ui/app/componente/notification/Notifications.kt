package com.example.helpline.ui.app.Componente.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NotificationItem(image: Int, name: String, action: String) {
  Column {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 14.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Image(
        painter = painterResource(id = image),
        contentDescription = "User Avatar",
        modifier = Modifier.size(45.dp)
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(
        text = "$name $action",
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold
      )
    }
    Divider(color = Color(0x17000000), thickness = 1.dp)
  }
}