package com.helpline.view.forum

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.helpline.ui.app.componente.Loader
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
    var isLoading by remember { mutableStateOf<Boolean>(true) }

    fun fetchPosts() {

        postsViewModel.getPosts(
            onSuccess = { response ->
                posts.clear()
                posts.addAll(response.posts)
                isLoading = false
            },
            onFailure = { error ->
                isLoading = false
            })
    }

    fun likePost(post: Post) {
        postsViewModel.likePost(
            post = post,
            onSuccess = {
                fetchPosts()
            },
            onFailure = {

            })

    }

    LaunchedEffect(Unit) {
        fetchPosts()
    }

    Scaffold(
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .background(Color.Red)
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { innerPadding ->
            NavDrawer(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            ) {
                // Usando um Box para sobrepor o conteúdo e o footer
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    if(isLoading) {
                        Loader()
                    } else {
                        LazyColumn (
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(
                                    bottom = 60.dp,
                                    top = 120.dp
                                )
                        ) {
                            items(posts) { post ->
                                Post(
                                    postInfo = post,
                                    onLike = { p -> likePost(p) })
                            }
                        }
                    }
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
