package com.example.helplineapp.View.Edition

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.helplineapp.R

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun EditionProfileContent() {
    var celular by remember { mutableStateOf(TextFieldValue("")) }
    var instagram by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf("") }
    var biography by remember { mutableStateOf("") }
    var competencias by remember { mutableStateOf(mutableStateListOf(TextFieldValue(""))) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(255, 255, 255))
                .verticalScroll(rememberScrollState())
        ) {
            Header()
            BackgroundPhoto()
            ProfilePhoto()
            NameField(name) { name = it }
            BiographyField(biography) { biography = it }
            ContactField("Celular", "Informe seu número de contato", celular) { celular = it }
            ContactField("Instagram", "Adicione seu perfil do Instagram", instagram) { instagram = it }
            CompetenciesField(competencias) {
                competencias.add(TextFieldValue("")) // Adiciona um novo campo de entrada
            }
            ActionButtons()
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Ação de voltar */ }, modifier = Modifier.size(30.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Voltar", tint = Color.Black)
        }
        Text(text = stringResource(id = R.string.editar_perfil), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, fontFamily = poppinsFamily, modifier = Modifier.padding(start = 16.dp))
    }
}

@Composable
fun BackgroundPhoto() {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Editar Capa",
            tint = Color(0xFFDD7631),
            modifier = Modifier.size(20.dp) // Define o tamanho do ícone
        )
        Text(text = stringResource(id = R.string.imagem_capa_editar), fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = poppinsFamily,  color = Color(0xFF585C60), modifier = Modifier.padding(start = 8.dp))
    }
    Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(Color.Gray)) {
        Image(painter = painterResource(id = R.drawable.capa_profile), contentDescription = "Imagem de Capa", contentScale = ContentScale.Crop, modifier = Modifier.height(150.dp).fillMaxWidth())
    }
}

@Composable
fun ProfilePhoto() {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Editar Foto de Perfil",
            tint = Color(0xFFDD7631),
            modifier = Modifier.size(20.dp) // Define o tamanho do ícone
        )
        Text(text = stringResource(id = R.string.foto_perfil_editar), fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = poppinsFamily, color = Color(0xFF585C60), modifier = Modifier.padding(start = 8.dp))
    }
    Box(modifier = Modifier.size(120.dp).clip(CircleShape).padding(start = 16.dp)) {
        Image(painter = painterResource(id = R.drawable.profile_image), contentDescription = "Foto de Perfil", modifier = Modifier.size(120.dp))
    }
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun NameField(name: String, onNameChange: (String) -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Editar Nome",
            tint = Color(0xFFDD7631),
            modifier = Modifier.size(20.dp) // Define o tamanho do ícone
        )
        Text(text = stringResource(id = R.string.nome), fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = poppinsFamily, color = Color(0xFF585C60), modifier = Modifier.padding(start = 8.dp))
    }

    TextField(
        value = name,
        onValueChange = onNameChange,
        placeholder = { Text(text = stringResource(id = R.string.como_devemos_te_chamar)) },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun BiographyField(biography: String, onBiographyChange: (String) -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Editar Biografia",
            tint = Color(0xFFDD7631),
            modifier = Modifier.size(20.dp) // Define o tamanho do ícone
        )
        Text(text = stringResource(id = R.string.biografia), fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = poppinsFamily, color = Color(0xFF585C60), modifier = Modifier.padding(start = 8.dp))
    }

    TextField(
        value = biography,
        onValueChange = onBiographyChange,
        placeholder = { Text(text = stringResource(id = R.string.fale_um_pouco_sobre_voce)) },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun ContactField(label: String, placeholder: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Editar $label",
            tint = Color(0xFFDD7631),
            modifier = Modifier.size(20.dp) // Define o tamanho do ícone
        )
        Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = poppinsFamily,  color = Color(0xFF585C60), modifier = Modifier.padding(start = 8.dp))
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun CompetenciesField(competencias: SnapshotStateList<TextFieldValue>, onAddCompetency: () -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Editar Competências",
            tint = Color(0xFFDD7631),
            modifier = Modifier.size(20.dp) // Define o tamanho do ícone
        )
        Text(text = stringResource(id = R.string.competencias_usuario_editar), fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = poppinsFamily,  color = Color(0xFF585C60), modifier = Modifier.padding(start = 8.dp))
    }

    for (index in competencias.indices) {
        val competencia = competencias[index]
        TextField(
            value = competencia,
            onValueChange = { newValue -> competencias[index] = newValue },
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = stringResource(id = R.string.adicionar_competencia)) },
            trailingIcon = {
                IconButton(
                    onClick = {
                        competencias.removeAt(index)
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.excluir),
                        contentDescription = "Excluir Competência",
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
        Button(
            onClick = onAddCompetency,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF285430), contentColor = Color.White),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "+ Adicionar Competência", fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { /* Cancelar */ },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF285430)),
            border = BorderStroke(2.dp, Color(0xFF285430)),
        ) {
            Text(text = stringResource(id = R.string.cancelar), fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold)
        }

        Button(
            onClick = { /* Salvar */ },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF285430), contentColor = Color.White)
        ) {
            Text(text = stringResource(id = R.string.salvar), fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEditionProfile() {
    EditionProfileContent()
}
