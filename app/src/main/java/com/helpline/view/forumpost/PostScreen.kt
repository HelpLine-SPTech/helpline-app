package com.helpline.view.forumpost

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.helpline.R
import com.helpline.ui.app.componente.forum.sidebar.NavDrawer
import com.helpline.ui.app.componente.footer.BottomNavBar
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.helpline.config.Session
import com.helpline.ui.app.componente.PicassoImage
import com.helpline.viewmodel.forum.ForumViewModel
import com.helpline.viewmodel.post.PostViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.koin.compose.koinInject
import java.io.File

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun PostScreen(navController: NavController, postViewModel: PostViewModel) {
    var context = LocalContext.current
    var textState by remember { mutableStateOf(TextFieldValue()) }
    var selectedImages = remember { mutableStateListOf<Uri>() }

    var session = koinInject<Session>()

    val multipleImagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) { uris: List<Uri>? ->
        // Handle the selected images here
        if (uris != null) {
            selectedImages.clear()
            selectedImages.addAll(uris)
            Log.d("Uploud de img", "funcionou $uris")
        }
    }

    fun uriToFile(context: Context, uri: Uri): File {
        val contentResolver = context.contentResolver
        val inputStream = contentResolver.openInputStream(uri)
        val tempFile = File.createTempFile("image", ".jpg", context.cacheDir)
        inputStream?.use { input ->
            tempFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        return tempFile
    }

    fun prepareFilePart(context: Context, uri: Uri, partName: String): MultipartBody.Part {
        val file = uriToFile(context, uri)
        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }

    fun submit() {

        val images = selectedImages.map { uri ->
            prepareFilePart(context, uri, "images")
        }

        postViewModel.createPost(
            images = images,
            content = textState.text,
            onSuccess = { response ->
                if (response.success) {
                    Toast.makeText(context, "Post criado com sucesso!", Toast.LENGTH_LONG).show()
                    Log.d("NAVEGAÇÃO POST", "funcionou")
                    navController.navigate("forumScreen")
                } else {
                    Toast.makeText(context, "Erro ao fazer o post", Toast.LENGTH_LONG).show()
                }

            },
            onFailure = { error ->
                    Toast.makeText(context, "Erro ao fazer o post ${error.message()}", Toast.LENGTH_LONG).show()
            })
    }

    NavDrawer(navController = navController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
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
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                            .fillMaxHeight(0.7f)
                    )
                    {
                        PicassoImage(
                            imageUrl = session.loggedUser?.profilePicUrl ?: "",
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape) // Aplica a forma circular à imagem
                                .background(
                                    Color.Gray,
                                    shape = CircleShape
                                )
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
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(), // Faz a Row ocupar toda a largura disponível
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(), // Garante que o LazyRow respeite o alinhamento à esquerda
                            horizontalArrangement = Arrangement.Start // Adiciona alinhamento interno no LazyRow
                        ) {
                            items(selectedImages) { uri ->
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 10.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                ) {
                                    PicassoImage(
                                        imageUrl = uri.toString(),
                                        modifier = Modifier
                                            .height(50.dp)
                                            .width(50.dp)
                                    )
                                }
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Primeiro vem o botão de imagem
                            Button(
                                onClick = { multipleImagePickerLauncher.launch("image/*") },
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
                                onClick = { submit()},
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

//@Preview(showBackground = true)
//@Composable
//fun Post() {
//    val navController = rememberNavController()
//    PostScreen(navController = navController)
//}
