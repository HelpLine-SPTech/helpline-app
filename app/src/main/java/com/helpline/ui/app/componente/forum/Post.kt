package com.helpline.ui.app.componente.forum

import CommentItem
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.helpline.R
import com.helpline.network.forum.Comment
import com.helpline.network.forum.Post
import com.helpline.ui.app.componente.PicassoImage
import com.helpline.viewmodel.forum.ForumViewModel
import org.koin.compose.koinInject

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun Post(post: Post, onLike: (Post) -> Unit, navController: NavController) {
    var postInfo by remember { mutableStateOf(post)}
    var comments = remember { mutableStateListOf<Comment>() }
    var liked by remember { mutableStateOf(postInfo.liked) }
    var isCommentModalVisible by remember { mutableStateOf(false) }

    var viewModel: ForumViewModel = koinInject()

    LaunchedEffect(Unit) {
        comments.addAll(postInfo.comments)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEFEF))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically // Alinha verticalmente
            ) {
                PicassoImage(
                    imageUrl = postInfo.user.profilePicUrl
                        ?: "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png",
                    contentDescription = "profilePic",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .clickable { navController.navigate("profile/${postInfo.user.id}") },
                )
                Text(
                    text = postInfo.user.name,
                    fontSize = 18.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

            Text(
                text = postInfo.content,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .padding(top = 8.dp)
            )

            if (postInfo.images.isNotEmpty()) {
                postInfo.images.forEach {
                    PicassoImage(
                        imageUrl = it.url,
                        contentDescription = "Post Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)) // Arredondando a imagem
                            .height(180.dp),
                    )
                    if(postInfo.images.indexOf(it) != postInfo.images.size - 1) {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Button(
                    onClick = {
                        liked = true
                        onLike(postInfo)
                    },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        .copy(contentColor = Color.Black)
                ) {
                    Icon(
                        imageVector = if (!liked) Icons.Outlined.ThumbUp else Icons.Filled.ThumbUp,
                        contentDescription = "Like"
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { isCommentModalVisible = true },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        .copy(contentColor = Color.Black)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Comment,
                        contentDescription = "Comentário"
                    )
                }
            }

            if (comments.isNotEmpty()) {
                // Lista de comentários
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    comments.forEach { comment ->
                        CommentItem(
                            comment = comment,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
        }
    }

    CommentModal(
        isVisible = isCommentModalVisible,
        onDismiss = { isCommentModalVisible = false },
        onSubmit = { newComment ->
            viewModel.commentOnPost(
                postId = postInfo.id.toString(),
                content = newComment,
                onSuccess = {
                    comments.add(it.comment)
                    isCommentModalVisible = false
                },
                onFailure = { isCommentModalVisible = false })
        }
    )
}

@Composable
fun CommentModal(
    isVisible: Boolean,          // Controla a visibilidade do modal
    onDismiss: () -> Unit,       // Ação para fechar o modal
    onSubmit: (String) -> Unit   // Ação para enviar o comentário
) {
    if (isVisible) {
        androidx.compose.ui.window.Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Adicionar Comentário",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFamily,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    var commentText by remember { mutableStateOf("") }

                    // Campo de texto para o comentário
                    androidx.compose.material3.OutlinedTextField(
                        value = commentText,
                        onValueChange = { commentText = it },
                        label = { Text("Digite seu comentário") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Botão de enviar
                    Button(
                        onClick = {
                            if (commentText.isNotBlank()) {
                                onSubmit(commentText)
                                onDismiss() // Fecha o modal após o envio
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                    ) {
                        Text("Enviar", color = Color.White)
                    }
                }
            }
        }
    }
}