package com.example.helpline.ui.app.Componente.Forum

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.helpline.R

val poppinsFamily = FontFamily(
  Font(R.font.poppins_regular, FontWeight.Normal),
  Font(R.font.poppins_bold, FontWeight.Bold),
  Font(R.font.poppins_medium, FontWeight.Medium),
  Font(R.font.poppins_semibold, FontWeight.SemiBold),
  Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun Post( nome: String, texto: String, profilePic: Int, postImage: Boolean){
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    shape = RoundedCornerShape(20.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEFEF))
  ) {
    Column(
      modifier = Modifier.padding(16.dp),
      horizontalAlignment = Alignment.Start,
    ) {
      // Linha para a foto e nome do usuário
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically // Alinha verticalmente
      ) {
        Image(
          painter = painterResource(id = profilePic),
          contentDescription = "profilePic",
          modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(20.dp)), // Arredondando a imagem
        )
        // Nome do usuário
        Text(
          text = nome,
          fontSize = 18.sp,
          fontFamily = poppinsFamily,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(start = 10.dp) // Espaço entre a imagem e o texto
        )
      }

      // Texto da mensagem
      Text(
        text = texto,
        fontSize = 14.sp,
        fontFamily = poppinsFamily,
        modifier = Modifier.padding(bottom = 32.dp) // Espaçamento inferior
          .padding(top = 8.dp)
      )

      if (postImage){
        Image(
          painter = painterResource(id = com.example.helpline.R.mipmap.imgdoacao),
          contentDescription = "Cestas básicas",
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)) // Arredondando a imagem
            .height(180.dp),
        )
      }

      // Área de interações (curtir, comentar)
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 32.dp), // Espaçamento do topo entre a imagem e os botões
        horizontalArrangement = Arrangement.Start // Alinha à esquerda
      ) {
        Button(
          onClick = { /* Ação para curtir */ },
          modifier = Modifier.padding(end = 8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            .copy(contentColor = Color.Black)
        ) {
          Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "Like")
        }

        Spacer(modifier = Modifier.width(8.dp)) // Espaço entre os botões

        Button(
          onClick = { /* Ação para curtir */ },
          modifier = Modifier.padding(end = 8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            .copy(contentColor = Color.Black)
        ) {
          Icon(imageVector = Icons.AutoMirrored.Filled.Comment, contentDescription = "Comentário")
        }
      }
    }
  }

}