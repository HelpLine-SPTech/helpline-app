package com.example.helplineapp.View.Forum

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helplineapp.R
import com.example.helplineapp.ui.theme.Componente.Header.TopBar
import com.example.helplineapp.ui.theme.Componente.Footer.BottomNavBar
import com.example.helplineapp.ui.theme.Componente.Forum.Post

@Composable
fun ForumScreen(navController: NavController) {
    // Usando um Box para sobrepor o conteúdo e o footer
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Conteúdo principal que rola
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp) // Espaçamento para evitar sobreposição com o footer
                .verticalScroll(rememberScrollState()) // Permite que o conteúdo role
        ) {
            TopBar()

            // Card do post
            
            Post(nome = "Maria Eduarda", texto = "Oi pessoal, estou com algumas cestas básicas e gostaria de saber se alguma ONG poderia entrar em contato comigo para que eu possa fazer a doação.",
                profilePic = R.mipmap.fotomaria,
                postImage = true
            )
            
            // Adicione mais posts aqui conforme necessário
            // Post 2
            Post(
                "Julia Almeida",
                "Gostaria de saber se alguma ONG poderia entrar em contato comigo para eu possa fazer a doação.",
                    R.mipmap.img_julia_almeida,
                    false
            )

            // Post3
            Post(
                "Julio Cesar",
                "Estou tão feliz por ter sido voluntária e ter contribuído com a ONG que me vinculei! " +
                    "Foi uma experiência incrível e gratificante, saber que pude ajudar de alguma" +
                    " forma faz tudo valer a pena. Mal posso esperar para continuar colaborando" +
                    " e fazendo a diferença na comunidade.\n" +
                    "#BemDaMadrugada.",
                R.mipmap.img_julia_almeida,
                false
            )
        }


            // Footer fixo na parte inferior
        BottomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Alinha o footer na parte inferior do Box
                .fillMaxWidth()
                .height(60.dp) // Altura do footer
        )
    }
}