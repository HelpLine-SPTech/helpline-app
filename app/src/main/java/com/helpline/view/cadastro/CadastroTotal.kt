package com.example.helpline.View.Cadastro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helpline.R // Certifique-se de usar o R do seu pacote
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroFlow() {
    var currentStep by remember { mutableStateOf(0) }

    when (currentStep) {
        0 -> CadastroScreen(onNext = { currentStep++ })
        1 -> CadastroScreenT2(onNext = { currentStep++ }, onBack = { currentStep-- })
        2 -> CadastroScreenT3(onBack = { currentStep-- })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(onNext: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var confirmEmail by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmSenha by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF9F7))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp, vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(175.dp)
                    .aspectRatio(1.45f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.etapa_um_titulo),
                fontFamily = poppinsFamily,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF898888)
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(stringResource(id = R.string.email)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)), // Sombra aplicada
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = confirmEmail,
                    onValueChange = { confirmEmail = it },
                    label = { Text(stringResource(id = R.string.confirmar_email)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)), // Sombra aplicada
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text(stringResource(id = R.string.senha)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = confirmSenha,
                    onValueChange = { confirmSenha = it },
                    label = { Text(stringResource(id = R.string.confirme_senha)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = onNext,
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .wrapContentSize(align = Alignment.Center),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(28, 54, 30)),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Próximo", color = Color.White, fontFamily = poppinsFamily, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreenT2(onNext: () -> Unit, onBack: () -> Unit) {
    var nomeCompleto by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var competencias by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF9F7))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(175.dp)
                    .aspectRatio(1.45f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.etapa_dois_titulo),
                fontFamily = poppinsFamily,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF898888)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = nomeCompleto,
                    onValueChange = { nomeCompleto = it },
                    label = { Text(stringResource(id = R.string.nome_completo)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = dataNascimento,
                    onValueChange = { dataNascimento = it },
                    label = { Text(stringResource(id = R.string.data_nascimento)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = competencias,
                    onValueChange = { competencias = it },
                    label = { Text(stringResource(id = R.string.competencias_cadastro)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = onBack,
                        modifier = Modifier.width(95.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text("Voltar", color = Color.White, fontFamily = poppinsFamily, fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = onNext,
                        modifier = Modifier.width(110.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(28, 54, 30)),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text("Próximo", color = Color.White, fontFamily = poppinsFamily, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CadastroScreenT3(onBack: () -> Unit) {
    var cep by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF9F7))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(175.dp)
                    .aspectRatio(1.45f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.etapa_tres_titulo),
                fontFamily = poppinsFamily,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF898888)
                )
            )

            Spacer(modifier = Modifier.height(28.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = cep,
                    onValueChange = { cep = it },
                    label = { Text(stringResource(id = R.string.cep_cadastro)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = endereco,
                    onValueChange = { endereco = it },
                    label = { Text(stringResource(id = R.string.informe_seu_endereco)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = numero,
                    onValueChange = { numero = it },
                    label = { Text(stringResource(id = R.string.numero)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = complemento,
                    onValueChange = { complemento = it },
                    label = { Text(stringResource(id = R.string.informe_complemento)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = onBack,
                        modifier = Modifier.width(95.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text("Voltar", color = Color.White,  fontFamily = poppinsFamily, fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = { /* lógica de validação e finalização aqui */ },
                        modifier = Modifier.width(125.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(28, 54, 30)),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text("Confirmar", fontFamily = poppinsFamily, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CadastroFlowPreview() {
    CadastroFlow()
}
