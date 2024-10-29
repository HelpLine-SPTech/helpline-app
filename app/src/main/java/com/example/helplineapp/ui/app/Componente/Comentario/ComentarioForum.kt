package com.example.helplineapp.ui.app.Componente.Comentario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Photo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.R
import com.example.helplineapp.View.Chat.TelaChatScreen

@Composable

fun ComentarioForum(navController: NavController) {

    var comentario by remember { mutableStateOf("") }

    // Container principal
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFF5F5F5)) // Cor de fundo do container
//            .padding(16.dp)
//    ) {
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color.White) // Cor de fundo
            .padding(12.dp)
            .height(190.dp)
        ) {

            // Campo de comentário
            BasicTextField(
                value = comentario,
                onValueChange = { comentario = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .padding(end = 40.dp), // Espaço para o ícone de fechar
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(12.dp)
                    ) {
                        if (comentario.isEmpty()) {
                            Text(
                                stringResource(id = R.string.mensagem_componente),
                                style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                            )
                        }
                        innerTextField()
                    }
                }
            )

            // Ícone de adicionar imagem
            IconButton(
                onClick = {
                    // Ação para adicionar imagem
                },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Photo,
                    contentDescription = "Adicionar imagem",
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFF285430) // Cor verde do ícone
                )
            }

            // Botão de fechar (limpar comentário)
            IconButton(
                onClick = { comentario = "" },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Fechar",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Red // Cor vermelha do ícone
                )
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewComentario() {
    val navController = rememberNavController()
    ComentarioForum(navController = navController)
}