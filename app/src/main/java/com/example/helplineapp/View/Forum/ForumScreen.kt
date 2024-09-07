package com.example.helplineapp.View.Forum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import com.example.helplineapp.ui.theme.Componente.Header.TopBar
import com.example.helplineapp.ui.theme.Componente.Footer.BottomNavBar

@Composable
fun PostCard(navController: NavController) {
    // Header
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 15.dp), // Margem à esquerda
    ) {
        TopBar()

        // Container principal do post
        Column(
            modifier = Modifier
               .padding(10.dp) // Padding geral
                .background(Color(0xFFF2F6EF)) // Cor de fundo
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .weight(1f), // Permite que o conteúdo ocupe o espaço restante
            horizontalAlignment = Alignment.Start,
        ) {
            // Linha para a foto e nome do usuário
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically // Alinha verticalmente
            ) {
                Image(
                    painter = painterResource(id = com.example.helplineapp.R.mipmap.fotomaria),
                    contentDescription = "Foto Maria",
                    modifier = Modifier.size(50.dp)
                )
                // Nome do usuário
                Text(
                    text = "Maria Eduarda",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp) // Espaço entre a imagem e o texto
                )
            }

            // Texto da mensagem
            Text(
                text = "Oi pessoal, estou com algumas cestas básicas e gostaria de saber se alguma ONG poderia entrar em contato comigo para eu possa fazer a doação.",
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(bottom = 5.dp) // Espaçamento inferior
                    .padding(start = 30.dp),
            )

            // Imagem
            Image(
                painter = painterResource(id = com.example.helplineapp.R.mipmap.imgdoacao),
                contentDescription = "Cestas básicas",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(180.dp)
                    .width(100.dp)
                    .padding(start = 30.dp),
            )

            // Área de interações (curtir, comentar)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp),
                    horizontalArrangement = Arrangement.Start // Alinha à esquerda
            ) {
                Image(
                    painter = painterResource(id = com.example.helplineapp.R.mipmap.iconelike),
                    contentDescription = "Icone Like",
                    modifier = Modifier.size(20.dp)
                )

                Image(
                    painter = painterResource(id = com.example.helplineapp.R.mipmap.iconecomentario),
                    contentDescription = "Icone Comentario",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        // Footer fixo
        BottomNavBar()
    }
}