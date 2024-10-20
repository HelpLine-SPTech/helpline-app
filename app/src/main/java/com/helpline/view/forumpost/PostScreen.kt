package com.example.helpline.View.ForumPost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.helpline.R
import com.example.helpline.View.NavDrawer
import com.example.helpline.ui.app.Componente.Footer.BottomNavBar
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun PostScreen(navController: NavController) {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    NavDrawer {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Conteúdo principal que rola
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = 100.dp,
                        top = 120.dp
                    ) // Espaçamento para evitar sobreposição com o footer
                    .verticalScroll(rememberScrollState()) // Permite que o conteúdo role
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Altura flexível
                        .padding(10.dp)
                        .background(
                            Color(0xFFF2F6EF), shape = RoundedCornerShape(20.dp)
                        ),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                    )
                    {
                        Image(
                            painter = painterResource(id = R.mipmap.giovanna),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape) // Aplica a forma circular à imagem
                                .background(
                                    Color.Gray,
                                    shape = CircleShape
                                ), // Cor de fundo e forma circular
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        BasicTextField(
                            value = textState,
                            onValueChange = { textState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color(0xFFF2F6EF), shape = CircleShape)
                                .padding(16.dp),
                            textStyle = TextStyle(color = Color.Black, fontFamily = poppinsFamily, fontSize = 18.sp),
                            decorationBox = { innerTextField ->
                                if (textState.text.isEmpty()) {
                                    Text(
                                        stringResource(id = R.string.texto_publicacao),
                                        color = Color.Gray,
                                        fontFamily = poppinsFamily,
                                        fontSize = 18.sp
                                    )
                                }
                                innerTextField()
                            }
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Primeiro vem o botão de imagem
                            Button(
                                onClick = { /* Ação do botão de imagem */ },
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .width(40.dp)
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                contentPadding = PaddingValues(0.dp) // Remove o padding adicional do botão
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Photo,
                                    contentDescription = "Adicionar foto",
                                    tint = Color(0xFF585C60),
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp) // Define um padding de 4.dp no início (ajustável)
                                )
                            }

                            // Depois o botão de publicação
                            Button(
                                onClick = { /* Lógica de publicação */ },
                                modifier = Modifier
                                    .height(60.dp)
                                    .padding(end = 20.dp, bottom = 20.dp), // Ajuste padding no fim
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF285430),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(stringResource(id = R.string.publicar), fontFamily = poppinsFamily, fontSize = 16.sp)
                            }
                        }
                    }
                }
            }
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

@Preview(showBackground = true)
@Composable
fun Post() {
    val navController = rememberNavController()
    PostScreen(navController = navController)
}
