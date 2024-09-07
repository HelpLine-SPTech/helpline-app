package com.example.helplineapp.ui.theme.Componente.Footer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helplineapp.R
import androidx.compose.foundation.layout.Box

@Composable
fun BottomNavBar() {

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)), // Aplica o formato arredondado primeiro
        containerColor = Color(0xFF285430)
    ) {
        // Ícones de navegação
        NavigationBarItem(
            icon = {
                Image(painter = painterResource(id = R.mipmap.iconecasa),
                    contentDescription = "Icone Home",
                    modifier = Modifier.size(20.dp))
            },
            selected = false,
            onClick = { /* Ação para Home */ }
        )
        NavigationBarItem(
            icon = {
                Image(painter = painterResource(id = R.mipmap.iconepesquisa),
                    contentDescription = "Icone Pesquisa",
                    modifier = Modifier.size(20.dp))
            },
            selected = false,
            onClick = { /* Ação para Search */ }
        )
        NavigationBarItem(
            icon = {
                Image(painter = painterResource(id = R.mipmap.iconenotificacao),
                    contentDescription = "Icone Notificação",
                    modifier = Modifier.size(20.dp))
            },
            selected = false,
            onClick = { /* Ação para Notifications */ }
        )
        NavigationBarItem(
            icon = {
                Image(painter = painterResource(id = R.mipmap.iconechat),
                    contentDescription = "Icone Chat",
                    modifier = Modifier.size(20.dp))
            },
            selected = false,
            onClick = { /* Ação para Messages */ }
        )
        NavigationBarItem(
            icon = {
                Image(painter = painterResource(id = R.mipmap.iconevaga),
                    contentDescription = "Icone Vaga",
                    modifier = Modifier.size(20.dp))
            },
            selected = false,
            onClick = { /* Ação para Briefcase */ }
        )
    }
}

@Preview
@Composable
fun PreviewBottomNavBar() {
    BottomNavBar()
}