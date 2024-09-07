package com.example.helplineapp.ui.theme.Componente.Header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helplineapp.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun TopBar() {
    // Usamos Row para alinhar os itens horizontalmente
    Row(
        modifier = Modifier
            .fillMaxWidth() // Faz a linha ocupar a largura completa
            .padding(16.dp) // Margem interna
            .background(Color.White)// Define o fundo como branco
            .padding(16.dp), // Adiciona padding extra depois do background
        verticalAlignment = Alignment.CenterVertically, // Alinha verticalmente no centro
        horizontalArrangement = Arrangement.SpaceBetween // Espaço entre os itens
    ) {
        // Ícone de menu (esquerda)
        MenuIcon()

        // Logo "Help Line" (centro)
        Logo()

        // Imagem de perfil (direita)
        ProfileImage()
    }
}

@Composable
fun MenuIcon() {
  Image(painter = painterResource(id = R.mipmap.menulist),
      contentDescription = "Icone Menu",
      modifier = Modifier.size(50.dp))
}

@Composable
fun Logo() {
    Image(painter = painterResource(id = R.mipmap.imglogo),
        contentDescription = "Img Logo",
        modifier = Modifier.size(150.dp) )
}

@Composable
fun ProfileImage() {
  Image(painter = painterResource(id = R.mipmap.imgperfil),
      contentDescription = "Foto Perfil",
      modifier = Modifier.size(60.dp) )
}


@Preview
@Composable
fun PreviewTopBar() {
    TopBar()
}
