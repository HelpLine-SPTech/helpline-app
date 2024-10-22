package com.helpline.ui.app.componente.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController) {

    Row(
        modifier = Modifier
            .background(Color(0xFF285430)), // Cor de fundo do footer
        horizontalArrangement = Arrangement.SpaceAround, // Espaço entre os ícones
        verticalAlignment = Alignment.CenterVertically // Alinha os ícones verticalmente
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)), // Aplica o formato arredondado primeiro
            containerColor = Color(0xFF285430)
        ) {

            // Ícones de navegação
            NavigationBarItem(
                icon = {
                    Icon(imageVector = Icons.Default.Home,
                        contentDescription = "Home Button",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp))
                },
                selected = false,
                onClick = { /* Ação para Home */ }
            )

            NavigationBarItem(
                icon = {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "Search Button",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp))
                },
                selected = false,
                onClick = { /* Ação para Search */ }
            )
            NavigationBarItem(
                icon = {
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "Notification Button",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp))
                },
                selected = false,
                onClick = { /*navController.navigate("notificationScreen")*/ }
            )

            NavigationBarItem(
                icon = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Chat,
                        contentDescription = "Chat button",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp))
                },
                selected = false,
                onClick = { navController.navigate("chat-list") }
            )
            NavigationBarItem(
                icon = {
                    Icon(imageVector = Icons.Default.Work,
                        contentDescription = "Job button",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp))
                },
                selected = false,
                onClick = { /* Ação para Briefcase */ }
            )
        }
    }
}

//@Preview
//@Composable
//fun PreviewBottomNavBar() {
//    BottomNavBar(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)// Altura do footer
//    )
//}