package com.helpline.view.telapesquisa

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.helpline.R
import com.helpline.network.forum.User
import com.helpline.ui.app.componente.Loader
import com.helpline.ui.app.componente.PicassoImage
import com.helpline.viewmodel.search.SearchViewModel
import org.koin.androidx.compose.koinViewModel

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel) {

    val searchResult by viewModel.searchResult.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    fun search(term: String) {
        viewModel.search(term)
    }

    Scaffold(
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column {

                    // Cabeçalho com seta de voltar, título e ícone de notificação
                    Header(goBack = { navController.popBackStack() })

                    Spacer(modifier = Modifier.height(16.dp))

                    // Barra de pesquisa com fundo arredondado e lupa
                    SearchBar(onSearch = { search(it) })

                    Spacer(modifier = Modifier.height(16.dp))

                    if (isLoading) {
                        Loader()
                    } else if(searchResult.isNotEmpty()) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            items(searchResult) {
                                ConversationItem(
                                    user = it,
                                    onClick = { navController.navigate("/profile/${it.id}")}
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun Header(goBack: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Voltar",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .clickable { goBack() }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Busca",  // Alterado para "Busca"
            fontSize = 24.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.LightGray,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Pesquisar",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearch(searchText) }
                ),
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text(
                            text = "Pesquisar...",
                            fontSize = 16.sp,
                            fontFamily = poppinsFamily,
                            color = Color.Gray
                        )
                    }
                    innerTextField()
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ConversationItem(user: User, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagem de perfil
        PicassoImage(
            imageUrl = user.profilePicUrl ?: "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png",
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(48.dp)
                .clip(androidx.compose.foundation.shape.CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = user.name,
                fontFamily = poppinsFamily,
                fontSize = 16.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversasScreen() {
    val navController = rememberNavController()
    val viewModel = koinViewModel<SearchViewModel>()
    SearchScreen(navController, viewModel)
}
