package com.helpline.view.chat1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helpline.R
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
fun ConversasScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column {

            // Cabeçalho com seta de voltar e título
            Header()

            Spacer(modifier = Modifier.height(16.dp))

            // Barra de pesquisa com fundo arredondado e lupa
            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            // Exemplo de conversa
            ConversationItem(
                profilePic = R.drawable.profile2,
                name = "Noemi Santos",
                message = "Você vai participar da próxima campanha?",

                time = "10:35"
            )

            ConversationItem(
                profilePic = R.drawable.profile1,
                name = "Marcos Junior",
                message = "Quais produtos você doou?",
                time = "10:32"
            )

            ConversationItem(
                profilePic = R.drawable.profile3,
                name = "Luana Costa",
                message = "Está por dentro de alguma campanha...",
                time = "10:30"
            )
        }

        // Botão de iniciar nova conversa
        IconButton(
            onClick = { /* Ação para nova conversa */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFF555555)) // Cor roxa para destacar o botão
        ) {
            Icon(
                imageVector = Icons.Default.OpenInNew,
                contentDescription = "Nova conversa",
                tint = Color.White, // Cor do ícone
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Voltar",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .clickable { /* Ação de voltar */ }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Conversas",
            fontFamily = poppinsFamily,
            fontSize = 24.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun SearchBar() {
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
                    onSearch = {
                        // Ação quando o usuário pressiona "Search"
                    }
                ),
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text(
                            text = "Pesquisar...",
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
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
fun ConversationItem(profilePic: Int, name: String, message: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Ação para abrir conversa */ },
        verticalAlignment = Alignment.CenterVertically

    ) {
        // Imagem de perfil
        androidx.compose.foundation.Image(
            painter = androidx.compose.ui.res.painterResource(id = profilePic),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(androidx.compose.foundation.shape.CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    fontFamily = poppinsFamily,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color.Black
                )
                Text(text = time, fontFamily = poppinsFamily, fontSize = 14.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = message,
                fontFamily = poppinsFamily,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversasScreen() {
    ConversasScreen()
}
