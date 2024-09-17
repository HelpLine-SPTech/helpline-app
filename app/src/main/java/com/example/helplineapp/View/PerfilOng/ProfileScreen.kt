package com.example.helplineapp.View.PerfilOng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.helplineapp.R
import com.example.helplineapp.View.NavDrawer
import com.example.helplineapp.ui.theme.Componente.Footer.BottomNavBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255,255,255))
    ) {
        // Seta para voltar
        IconButton(
            onClick = { /* Ação de voltar */ },
            modifier = Modifier
                .padding(5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), // Substitua por seu ícone
                contentDescription = "Voltar",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Define a altura total da caixa (um pouco maior que a capa para incluir a imagem de perfil)
        ) {
            // Imagem de capa
            Image(
                painter = painterResource(id = R.drawable.capa_profile), // Coloque a capa aqui
                contentDescription = "Imagem de Capa",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp) // Altura da capa
                    .fillMaxWidth()
            )

            // Imagem de perfil com borda branca
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart) // Posiciona a imagem de perfil no canto inferior esquerdo
                    .offset(
                        y = 0.dp,
                        x = 16.dp
                    ) // Ajuste o valor de `y` para mover a imagem metade para fora da capa
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(3.dp) // Espaçamento da borda branca
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image), // Coloque a imagem de perfil aqui
                    contentDescription = "Foto de Perfil",
                    contentScale = ContentScale.Crop, // Ajusta o conteúdo da imagem
                    modifier = Modifier
                        .matchParentSize() // Faz com que a imagem ocupe todo o espaço disponível dentro do Box
                        .clip(CircleShape) // Mantém a forma circular da imagem
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Nome da ONG
        Text(
            text = "Bem da Madrugada",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Descrição
        Text(
            text = "O grupo Bem da Madrugada é uma ONG com foco na ajuda de necessitados no momento em que encontram-se menos amparados.",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Contato (ícones reservados)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_zap), // Reservado para ícone de telefone
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "11 91234-5678")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_instagram), // Reservado para ícone de Instagram
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "@bem_da_madrugada")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_loc), // Reservado para ícone de endereço
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Rua Vigário Albernaz, 738")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de "Doe aqui!"
        Button(
            onClick = { /* Ação de doação */ },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .width(120.dp) // Define a largura do botão. Ajuste conforme necessário
                .align(Alignment.Start), // Centraliza horizontalmente
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(37, 71, 43)),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Doe aqui!",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Selos
        Text(
            text = "Selos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.selo), // Coloque o selo aqui
                contentDescription = "Selo ONG",
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campanhas Ativas
        Text(
            text = "Campanhas Ativas",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        CampaignListItem("Tutor Voluntário para Reforço Escolar")
        CampaignListItem("Assistente de Eventos Voluntário")
        CampaignListItem("Voluntário para Cuidados de Animais Abandonados")
    }
}

@Composable
fun CampaignListItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color(0xFFFF9800), CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}