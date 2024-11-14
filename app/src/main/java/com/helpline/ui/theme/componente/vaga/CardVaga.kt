package com.helpline.ui.theme.componente.vaga

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.helpline.R
import com.helpline.network.vaga.Job
import com.helpline.view.vaga.poppinsFamily

@Composable
fun CardVagas(job: Job){
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                // Imagem do topo (com pets)
                Image(
                    painter = painterResource(id = R.mipmap.img_pet_vaga),
                    contentDescription = "imagem de pet",
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
                job.user?.let {
                    Text(
                        text = it.name,
                        fontFamily = poppinsFamily,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

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
                        text =  stringResource(id = R.string.inscrevase),
                        fontFamily = poppinsFamily,
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

                Text(text =  stringResource(id = R.string.vaga),
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(text = job.title,
                    fontFamily = poppinsFamily,
                    style = MaterialTheme.typography.bodyMedium)

                //Spacer(modifier = Modifier.height(8.dp))


                Text(text = stringResource(id = R.string.endereco),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily
                )
                Text( text = "${job.address?.city} - ${job.address?.state}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = poppinsFamily
                )

                Text(text = stringResource(id = R.string.descricao_vaga),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily
                )
                Text(text = job.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = poppinsFamily
                )

                Row {
                    Text(text = stringResource(id = R.string.qtd_vaga),
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFamily,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(text = job.amount.toString(),
                        fontFamily = poppinsFamily,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row {
                    Text(text = stringResource(id = R.string.data_hora),
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFamily,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    job.date?.let {
                        Text(text = it,
                            fontFamily = poppinsFamily,
                            style = MaterialTheme.typography.bodyMedium )
                    }
                }
            }

        }
    }
}