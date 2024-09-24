package com.example.helplineapp.View.vaga

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helplineapp.R
import com.example.helplineapp.ui.app.Componente.Footer.BottomNavBar
import com.example.helplineapp.View.NavDrawer

@Composable
fun VagaScreen (){
    //navController: NavController
    // menu lateral
    NavDrawer {
        // Usando um Box para sobrepor o conteúdo e o footer
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Conteúdo principal que rola
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = 60.dp,
                        top = 120.dp
                    ) // Espaçamento para evitar sobreposição com o footer
                    .verticalScroll(rememberScrollState()) // Permite que o conteúdo role
            ) {
                // conteudo - primeiro post de vaga
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    // define o sombreamento do elemento
                    elevation = CardDefaults.cardElevation(4.dp),
                    // arrendando as bordas
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors( // Definir a cor de fundo
                        containerColor = Color(0xFFF2F6EF)
                    ) // Usando o parâmetro containerColor
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        // Imagem do topo (com pets)
                    Image(painter = painterResource(id = R.mipmap.img_pet_vaga),
                        contentDescription = "imagem de pet",
                         modifier = Modifier
                             .fillMaxWidth()
                             .height(150.dp)
                             .clip(RoundedCornerShape(16.dp)), // Aplica o arredondamento
                        contentScale = ContentScale.Crop
                    )
                        // dar espaço entre elementos
                        Spacer(modifier = Modifier.height(5.dp))

                        // Nome da vaga e botão
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                text = "Amigos de Belém",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Button(
                                onClick = { /* Ação do botão */ },
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(20.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF25472B)),
                                contentPadding = PaddingValues(0.dp), // Remove padding adicional
                            ) {
                                Text(
                                    text = "Inscreva-se",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.CenterVertically) // Centraliza verticalmente
                                )
                            }
                            Button(onClick = { /* Ação do botão */ },
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                contentPadding = PaddingValues(0.dp)
                                ) {
                                Icon(
                                    imageVector = Icons.Filled.ChatBubble,
                                    contentDescription = "Chat",
                                    tint = Color(0xFF585C60),
                                    modifier = Modifier.size(24.dp) // Tamanho do ícone
                                )
                            }
                        }

                        //Spacer(modifier = Modifier.height(2.dp))

                        // Descrição da vaga
                        Column {

                                Text(text = "Vaga:",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "Voluntário para Cuidados de Animais Abandonados",
                                        style = MaterialTheme.typography.bodyMedium)

                            //Spacer(modifier = Modifier.height(8.dp))


                                Text(text = "Endereço:",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "Endereço: Abrigo de Animais XYZ, Estrada dos Bichinhos, S/N",
                                    style = MaterialTheme.typography.bodyMedium)

                            //Spacer(modifier = Modifier.height(8.dp))

                                Text(text = "Descrição da vaga:",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "• Auxiliar na alimentação, higiene e exercícios dos animais residentes no abrigo",
                                    style = MaterialTheme.typography.bodyMedium)

                            Row {
                                Text(text = "Quantidade de vagas:",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(text = "2",style = MaterialTheme.typography.bodyMedium )
                            }
                            Row {
                                Text(text = "Horário:",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(text = "10h00 às 14h00",style = MaterialTheme.typography.bodyMedium )
                            }
                            Row {
                                Text(text = "Dias da semana:",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(text = "Terça-feira e Quinta-feira",style = MaterialTheme.typography.bodyMedium )
                            }
                        }

                    }
                }

            }
            // Footer fixo na parte inferior
            BottomNavBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Alinha o footer na parte inferior do Box
                    .fillMaxWidth()
                    .height(60.dp),
                /*navController*/
            )
        }
     }
    }
@Preview(showBackground = true)
@Composable
fun PreviewVagaScreen() {
    VagaScreen()
}
