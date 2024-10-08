package com.example.helplineapp.View.Forum

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.helplineapp.R
import com.example.helplineapp.View.NavDrawer
import com.example.helplineapp.ui.app.Componente.Footer.BottomNavBar
import com.example.helplineapp.ui.app.Componente.Forum.Post


@Composable
fun ForumScreen(navController: NavController) {
    NavDrawer {
        // Usando um Box para sobrepor o conteúdo e o footer
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Conteúdo principal que rola
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp, top = 120.dp) // Espaçamento para evitar sobreposição com o footer
                    .verticalScroll(rememberScrollState()) // Permite que o conteúdo role
            ) {
                // O TopBar já está sendo chamado dentro do NavDrawer
                // Conteúdo da tela
                Post(
                    nome = "Maria Eduarda",
                    texto = "Oi pessoal, estou com algumas cestas básicas e gostaria de saber se alguma ONG poderia entrar em contato comigo para que eu possa fazer a doação.",
                    profilePic = R.drawable.profile_maria_eduarda,
                    postImage = true
                )

                // Post 2
                Post(
                    "Julia Almeida",
                    "Gostaria de saber se alguma ONG poderia entrar em contato comigo para eu possa fazer a doação.",
                    R.mipmap.img_julia_almeida,
                    false
                )

                // Post 3
                Post(
                    "Adriano Leite Ribeiro",
                    "Estou tão feliz por ter sido voluntária e ter contribuído com a ONG que me vinculei! " +
                        "Foi uma experiência incrível e gratificante, saber que pude ajudar de alguma" +
                        " forma faz tudo valer a pena. Mal posso esperar para continuar colaborando" +
                        " e fazendo a diferença na comunidade.\n" +
                        "#BemDaMadrugada.",
                    R.mipmap.profile_adriano,
                    false
                )
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
