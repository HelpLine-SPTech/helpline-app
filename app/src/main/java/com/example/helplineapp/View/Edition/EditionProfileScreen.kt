package com.example.helplineapp.View.Edition

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.TextStyle
import com.example.helplineapp.R

@Composable
fun EditionProfileContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(255, 255, 255))
                .verticalScroll(rememberScrollState())
        ) {

            // Row de seta e título
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { /* Ação de voltar */ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Voltar",
                        tint = Color.Black
                    )
                }
                Text(
                    text = "Editar Perfil",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
            }

            // Foto de fundo
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Plano de Fundo",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Foto Fundo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.capa_profile),
                    contentDescription = "Imagem de Capa",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
            }

            // Foto de perfil
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Foto de Perfil",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Foto Perfil",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .padding(start = 16.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_maria_eduarda), // Substituir pela imagem real
                    contentDescription = "Foto de Perfil",
                    modifier = Modifier.size(180.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nome
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Nome",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Nome",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            TextField(
                value = "Daniel Santos",
                onValueChange = {},
                placeholder = {
                    Text(text = "Nome")},
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Biografia
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Biografia",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Biografia",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            TextField(
                value = "Sou voluntário há 5 anos...",
                onValueChange = {},
                placeholder = { Text(text = "Biografia") },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Demais campos continuam...


            Spacer(modifier = Modifier.height(8.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Celular",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Celular",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Celular
            var celular by remember { mutableStateOf(TextFieldValue("(11) 99367-1601")) }
            TextField(
                value = celular,
                onValueChange = { celular = it },
                label = { Text("") },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Instagram",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Instagram",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            // Instagram
            var instagram by remember { mutableStateOf(TextFieldValue("duda_maria")) }
            TextField(
                value = instagram,
                onValueChange = { instagram = it },
                label = { Text("") },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Editar Competências",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Competências",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Competências
            var competencias by remember { mutableStateOf(listOf("Inglês básico", "Comunicação escrita", "Habilidade em cozinhar", "Liderança")) }
            competencias.forEachIndexed { index, competencia ->
                TextField(
                    value = competencia,
                    onValueChange = { newValue ->
                        competencias = competencias.toMutableList().apply { set(index, newValue) }
                    },
                    shape = RoundedCornerShape(16.dp),
                    label = { Text("") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Botão de adicionar competência
            Button(
                onClick = { /* Adicionar nova competência */ },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF285430), // Cor de fundo verde
                    contentColor = Color.White // Cor do texto branco
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp)
            ) {
                Text("+ Adicionar Competência")
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Botões Cancelar e Salvar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Cancelar */ },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF285430) // Define a cor da borda e do texto como verde
                    ),
                    border = BorderStroke(2.dp, Color(0xFF285430)), // Define a espessura e a cor da borda
                ) {
                    Text("Cancelar")
                }

                Button(
                    onClick = { /* Salvar */ },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF285430), // Cor de fundo personalizada
                        contentColor = Color.White // Cor personalizada
                    )
                ) {
                    Text("Salvar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEditionProfile() {
    EditionProfileContent()
}
