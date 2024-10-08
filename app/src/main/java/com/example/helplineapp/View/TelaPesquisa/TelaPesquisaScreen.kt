package com.example.helplineapp.View.TelaPesquisa

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helplineapp.R

@Composable
fun ConversasScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column {

            // Cabeçalho com seta de voltar, título e ícone de notificação
            Header()

            Spacer(modifier = Modifier.height(16.dp))

            // Barra de pesquisa com fundo arredondado e lupa
            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            // Exemplo de conversa
            ConversationItem(
                profilePic = R.mipmap.ong1,
                name = "Bem da Madrugada",
                message = "Rua das Flores, 123\nJardim das Esperanças, SP, 01234–567"
            )

            ConversationItem(
                profilePic = R.mipmap.ong2,
                name = "Amigos de Belém",
                message = "Avenida da Liberdade, 456\nCentro, RJ, 98765–432"
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
            text = "Busca",  // Alterado para "Busca"
            fontSize = 24.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.weight(1f))  // Empurra o ícone de notificação para a direita

        // Ícone de notificação adicionado no topo direito
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notificações",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .clickable { /* Ação para notificações */ }
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
fun ConversationItem(profilePic: Int, name: String, message: String) {
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
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Alterando o texto, removendo a hora e exibindo uma mensagem diferente
            Text(
                text = message,
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
