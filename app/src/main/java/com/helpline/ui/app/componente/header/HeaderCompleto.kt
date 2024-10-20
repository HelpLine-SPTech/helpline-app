package com.example.helpline.ui.app.Componente.Header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(onMenuClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(17.dp, 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Ícone de menu (esquerda)
        MenuIcon(onClick = onMenuClick)

        // Espaço flexível para garantir que a logo fique no centro
        Spacer(modifier = Modifier.weight(1.4f)) // Espaço flexível para empurrar a logo para o centro
        Logo()
        Spacer(modifier = Modifier.weight(1f))

        // Imagem de perfil (direita)
        ProfileImage()
    }
}

@Composable
fun MenuIcon(onClick: () -> Unit) {
    Icon(
        painter = painterResource(id = R.mipmap.menulist),
        contentDescription = "Menu",
        modifier = Modifier
            .size(30.dp)
            .clickable(onClick = onClick), // Clique para abrir o NavigationDrawer
        tint = Color.Black,
    )
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier = Modifier
            .width(100.dp)
            .aspectRatio(1.23f),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.mipmap.imgperfil),
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape)
    )
}

//
//@Preview
//@Composable
//fun PreviewTopBar() {
//    TopBar()
//}
