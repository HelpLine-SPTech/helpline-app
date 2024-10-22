package com.helpline.view.campanha

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.helpline.R
import com.helpline.ui.app.componente.forum.sidebar.NavDrawer
import com.helpline.ui.app.componente.footer.BottomNavBar


@Composable
fun CampanhaScreen (navController: NavController) {
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
            ){
                // conteudo - primeiro post campanha
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

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            // Imagem do topo (com pets)
                            Image(
                                painter = painterResource(id = R.mipmap.doacao_leite),
                                contentDescription = "imagem campanha leite",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(16.dp))// Aplica o arredondamento
                                    .align(Alignment.Center),
                                contentScale = ContentScale.Crop
                            )
                        }
                        // dar espaço entre elementos
                        Spacer(modifier = Modifier.height(5.dp))

                        // Nome da vaga e botão
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp), // Defina a altura desejada
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                text = stringResource(id = R.string.campanha_um),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                        }

                        // Descrição da vaga
                        Column {

                            Spacer(modifier = Modifier.height(1.dp))


                            Text(text =  stringResource(id = R.string.objetivo_um),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = stringResource(id = R.string.text_objetivo_um),
                                style = MaterialTheme.typography.bodyMedium)


                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = stringResource(id = R.string.subtitulo_um),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            
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
                                    text =  stringResource(id = R.string.doe_aqui),
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.CenterVertically) // Centraliza verticalmente
                                )
                            }
                        }

                    }
                }

                /* segunda campanha */
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

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            // Imagem do topo (com pets)
                            Image(
                                painter = painterResource(id = R.mipmap.campanha_ambiental),
                                contentDescription = "imagem campanha ambiental",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(16.dp))// Aplica o arredondamento
                                    .align(Alignment.Center),
                                contentScale = ContentScale.Crop
                            )
                        }
                        // dar espaço entre elementos
                        Spacer(modifier = Modifier.height(5.dp))

                        // Nome da vaga e botão
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp), // Defina a altura desejada
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                text = stringResource(id = R.string.campanha_dois),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                        }

                        // Descrição da vaga
                        Column {

                            Spacer(modifier = Modifier.height(1.dp))


                            Text(text =  stringResource(id = R.string.objetivo_um),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = stringResource(id = R.string.text_objetivo_um),
                                style = MaterialTheme.typography.bodyMedium)


                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = stringResource(id = R.string.subtitulo_um),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

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
                                    text =  stringResource(id = R.string.doe_aqui),
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.CenterVertically) // Centraliza verticalmente
                                )
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
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PreviewScreen() {
    val navController = rememberNavController()
  CampanhaScreen(navController = navController)
}
