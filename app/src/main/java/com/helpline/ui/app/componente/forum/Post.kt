package com.helpline.ui.app.componente.forum

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.helpline.R
import com.helpline.network.forum.Post
import com.helpline.ui.app.componente.PicassoImage

val poppinsFamily = FontFamily(
  Font(R.font.poppins_regular, FontWeight.Normal),
  Font(R.font.poppins_bold, FontWeight.Bold),
  Font(R.font.poppins_medium, FontWeight.Medium),
  Font(R.font.poppins_semibold, FontWeight.SemiBold),
  Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun Post( postInfo: Post, onLike: (Post) -> Unit){
  var liked by remember { mutableStateOf(postInfo.liked) }

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
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically // Alinha verticalmente
      ) {
        PicassoImage(
          imageUrl = postInfo.user.profilePicUrl ?: "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png",
          contentDescription = "profilePic",
          modifier = Modifier
            .size(50.dp)
            .clip(CircleShape),
        )
        Text(
          text = postInfo.user.name,
          fontSize = 18.sp,
          fontFamily = poppinsFamily,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(start = 10.dp)
        )
      }

      Text(
        text = postInfo.content,
        fontSize = 14.sp,
        fontFamily = poppinsFamily,
        modifier = Modifier.padding(bottom = 32.dp)
          .padding(top = 8.dp)
      )

      if (postInfo.images.isNotEmpty()){
        postInfo.images.forEach {
          PicassoImage(
            imageUrl = it.url,
            contentDescription = "Post Image",
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp)) // Arredondando a imagem
              .height(180.dp),
          )
        }
      }

      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 32.dp),
        horizontalArrangement = Arrangement.Start
      ) {
        Button(
          onClick = {
            liked = true
            onLike(postInfo)
          },
          modifier = Modifier.padding(end = 8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            .copy(contentColor = Color.Black)
        ) {
          Icon(imageVector = if (!liked) Icons.Outlined.ThumbUp else Icons.Filled.ThumbUp, contentDescription = "Like")
        }

        Spacer(modifier = Modifier.width(8.dp))

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