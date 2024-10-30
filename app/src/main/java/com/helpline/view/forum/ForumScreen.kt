package com.helpline.view.forum

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helpline.ui.app.componente.forum.sidebar.NavDrawer
import com.helpline.ui.app.componente.footer.BottomNavBar
import com.helpline.ui.app.componente.forum.Post
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.helpline.R
import com.helpline.network.forum.Post
import com.helpline.viewmodel.forum.ForumViewModel

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)


@Composable
fun ForumScreen(navController: NavController, postsViewModel: ForumViewModel) {

    var posts = remember { mutableStateListOf<Post>() }

    LaunchedEffect(Unit) {
        postsViewModel.getPosts(
            onSuccess = { response ->
                posts.addAll(response.posts)
            },
            onFailure = { error ->

            })
    }

    Scaffold(
        content = { innerPadding ->
            NavDrawer(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            ) {
                // Usando um Box para sobrepor o conteúdo e o footer
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Conteúdo principal que rola
                    // Usar LazyColumn
                    Column(
                        modifier = Modifier
//                    .fillMaxSize()
                            .padding(
                                bottom = 60.dp,
                                top = 120.dp
                            ) // Espaçamento para evitar sobreposição com o footer
                            .verticalScroll(rememberScrollState()) // Permite que o conteúdo role
                    ) {
                        posts.forEach {
                            Post(postInfo = it)
                        }
                    }

                    // Footer fixo na parte inferior

                }
            }
        },
        bottomBar = {
            BottomNavBar(
                modifier = Modifier // Alinha o footer na parte inferior do Box
                    .fillMaxWidth()
                    .height(60.dp),
                navController = navController
            )
        }
    )

}

@Composable
fun PostCard() {

}
