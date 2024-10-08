package com.example.helplineapp.View.PerfilOng

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.helplineapp.R
import com.example.helplineapp.ui.app.Componente.Footer.BottomNavBar

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

sealed class ProfileType {
    object Ong : ProfileType()
    object Volunteer : ProfileType()
}

@Composable
fun ProfileScreen(profileType: ProfileType, navController: NavController) {
    when (profileType) {
        is ProfileType.Ong -> OngProfileContent(navController)
        is ProfileType.Volunteer -> VolunteerProfileContent(navController)
    }
}

@Composable
fun OngProfileContent(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(255, 255, 255))
                .verticalScroll(rememberScrollState())
        ) {
            IconButton(
                onClick = { /* Ação de voltar */ },
                modifier = Modifier.padding(5.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.voltar),
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.capa_profile),
                    contentDescription = stringResource(R.string.imagem_capa),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = 16.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(3.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = stringResource(R.string.foto_perfil),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .matchParentSize()
                            .clip(CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.ong_nome),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.ong_descricao),
                fontFamily = poppinsFamily,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_zap),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.contato_telefone), fontFamily = poppinsFamily,)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_instagram),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.contato_instagram), fontFamily = poppinsFamily,)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_loc),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.contato_endereco), fontFamily = poppinsFamily,)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Ação de doação */ },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(120.dp)
                    .align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(37, 71, 43)),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = stringResource(R.string.doacao),
                    fontFamily = poppinsFamily,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.selos),
                fontFamily = poppinsFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.selo),
                    contentDescription = stringResource(R.string.selo_nutrir),
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.campanhas_ativas),
                fontSize = 20.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
//
            Spacer(modifier = Modifier.height(8.dp))

            CampaignListItem(stringResource(R.string.campanha_tutor))
            CampaignListItem(stringResource(R.string.campanha_assistente))
            CampaignListItem(stringResource(R.string.campanha_cuidados))

            Spacer(modifier = Modifier.padding(40.dp))
        }

        BottomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(60.dp),
            navController = navController
        )
    }
}

@Composable
fun VolunteerProfileContent(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(255, 255, 255))
                .verticalScroll(rememberScrollState())
        ) {
            IconButton(
                onClick = { /* Ação de voltar */ },
                modifier = Modifier.padding(5.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.voltar),
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.capa_profile),
                    contentDescription = stringResource(R.string.imagem_capa),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = 16.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(3.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_maria_eduarda),
                        contentDescription = stringResource(R.string.foto_perfil),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .matchParentSize()
                            .clip(CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.voluntario_nome),
                fontFamily = poppinsFamily,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.voluntario_descricao),
                fontFamily = poppinsFamily,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
            ) {
                Row {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_zap),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = stringResource(R.string.contato_telefone), fontFamily = poppinsFamily,)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 30.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_instagram),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = stringResource(R.string.voluntario_instagram), fontFamily = poppinsFamily,)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.selos),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.selo_aconchego),
                    contentDescription = stringResource(R.string.selo_aconchego),
                    modifier = Modifier.size(80.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.selo_nutrir),
                    contentDescription = stringResource(R.string.selo_nutrir),
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.competencias_usuario),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    CampaignListItem(stringResource(R.string.habilidade_comunicacao))
                    CampaignListItem(stringResource(R.string.habilidade_cozinhar))
                }

                Column(modifier = Modifier.weight(0.8f)) {
                    CampaignListItem(stringResource(R.string.habilidade_lideranca))
                    CampaignListItem(stringResource(R.string.habilidade_ingles))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.novas_ongs),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                OngItem(stringResource(R.string.ong_bem_da_madrugada), R.drawable.profile_image)
                OngItem(stringResource(R.string.ong_nos_do_bem), R.drawable.profile_image)
            }

            Spacer(modifier = Modifier.padding(40.dp))
        }

        BottomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(60.dp),
            navController = navController
        )
    }
}

@Composable
fun OngItem(name: String, imageRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color(0xFFF1F3F4), shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = name, fontSize = 16.sp, fontFamily = poppinsFamily)
    }
}

@Composable
fun CampaignListItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color(0xFFFF9800), CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title, fontFamily = poppinsFamily)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    val navController = rememberNavController()
    ProfileScreen(profileType = ProfileType.Ong, navController = navController)
}