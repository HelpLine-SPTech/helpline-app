package com.example.helplineapp.View.Chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.View.PerfilOng.ProfileScreen
import com.example.helplineapp.ui.app.Componente.Chat.HeaderChat
import com.example.helplineapp.ui.app.Componente.Notification.Header.HeaderNotification

@Composable
fun TelaChatScreen(navController: NavController) {
    val backgroundColor = Color(0xFFF8FAF6)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 31.dp)
                .verticalScroll(rememberScrollState())
        ) {
            HeaderChat(navController)
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    contentPadding = PaddingValues(vertical = 70.dp)
                ) {
                    item {
                        // Mensagens esquerda
                        ReceivedMessage("Boa noite!")
                        ReceivedMessage("Não, pode falar.")

                        Spacer(modifier = Modifier.height(16.dp))

                        // Mensagens direita
                        SentMessage("Boa noite Noemi, tudo bem?")
                        SentMessage("Está ocupada?")
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 27.dp, vertical = 28.dp)
        ) {
            InputField("Mensagem...")
        }
    }
}

@Composable
fun ReceivedMessage(message: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFD9D9D9))
                .padding(10.dp)
        ) {
            Text(
                text = message,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun SentMessage(message: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFC5D6AC))
                .padding(10.dp)
        ) {
            Text(
                text = message,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun InputField(placeholder: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFD9D9D9))
            .padding(16.dp)
    ) {
        Text(
            text = placeholder,
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChat() {
    val navController = rememberNavController()
    TelaChatScreen(navController = navController)
}