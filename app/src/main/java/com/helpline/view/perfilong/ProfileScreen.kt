package com.helpline.view.perfilong

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.helpline.R
import com.helpline.network.forum.User
import com.helpline.ui.app.componente.PicassoImage
import com.helpline.ui.app.componente.footer.BottomNavBar
import com.helpline.viewmodel.perfil.PerfilViewModel
import java.util.UUID

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@Composable
fun ProfileScreen(navController: NavController, userid : String, perfilViewModel : PerfilViewModel) {
    LaunchedEffect(Unit){
        perfilViewModel.fetchPerfilData(UUID.fromString(userid), "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJoZWxwbGluZS1hcGkiLCJzdWIiOiJkMTU3NmNjMy0wMGVhLTRkZGUtOGRlZC1lNGUzYzY1NTQ4NDIiLCJleHAiOjE3MzE5ODc3MzJ9.rLlS-7wFFrK6YW2a1f99RIAXneegw_mFJDTOn3vNkxw")
    }
    val user by perfilViewModel.perfilData.collectAsState()
    if (user == null) return
    when (user?.type) {
        "OngEntity" -> OngProfileContent(navController, userid,user)
        "UserEntity" -> VolunteerProfileContent(navController, userid, user)
    }
}

@Composable
fun OngProfileContent(navController: NavController, userid: String, user: User?) {
    Scaffold (
        content = { innerPadding ->
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()) {
                // Conteúdo rolável
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(255, 255, 255))
                        .verticalScroll(rememberScrollState())
                ) {
                    // Seta para voltar
                    IconButton(
                        onClick = { /* Ação de voltar */ },
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Voltar",
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
                            contentDescription = "Imagem de Capa",
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
                            PicassoImage(
                                contentDescription = "Foto de Perfil",
                                imageUrl = user?.profilePicUrl ?: "https://i0.wp.com/digitalhealthskills.com/wp-content/uploads/2022/11/3da39-no-user-image-icon-27.png?fit=500%2C500&ssl=1",
                                modifier = Modifier
                                    .matchParentSize()
                                    .clip(CircleShape)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (user != null) {
                        Text(
                            text = user.name,
                            fontFamily = poppinsFamily,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (user != null) {
                        user.bio?.let {
                            Text(
                                text = it,
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                            )
                        }
                    }

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
                            Text(text = "11 91234-5678",fontFamily = poppinsFamily)
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
                            Text(text = "@bem_da_madrugada")
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
                            if (user != null) {
                                Text(text = "${user.address?.street}, ${user.address?.number}, ${user.address?.city}", fontFamily = poppinsFamily)
                            }
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
                        Text(text = "Doe aqui!",
                            color = Color.White,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Selos",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFamily,
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
                            contentDescription = "Selo ONG",
                            modifier = Modifier.size(80.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Campanhas Ativas",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFamily,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    if (user != null && user.campaigns != null) {
                        user.campaigns.forEach({
                            CampaignListItem(it.title)
                        })
                    }

                    Spacer(modifier = Modifier.padding(40.dp))
                }

            }
        },
        bottomBar = {
            BottomNavBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                navController = navController
            )
        }
    )
}


@Composable
fun VolunteerProfileContent(
    navController: NavController,
    userid: String,
    user: User?
) {
    Scaffold(
        content = { innerPadding ->
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(255, 255, 255))
                        .verticalScroll(rememberScrollState())
                ) {
                    // Seta para voltar
                    IconButton(
                        onClick = { /* Ação de voltar */ },
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Voltar",
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
                            contentDescription = "Imagem de Capa",
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
                            PicassoImage(
                                contentDescription = "Foto de Perfil",
                                imageUrl = user?.profilePicUrl ?: "https://i0.wp.com/digitalhealthskills.com/wp-content/uploads/2022/11/3da39-no-user-image-icon-27.png?fit=500%2C500&ssl=1",
                                modifier = Modifier
                                    .matchParentSize()
                                    .clip(CircleShape)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (user != null) {
                        Text(
                            text = user.name,
                            fontSize = 24.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (user != null) {
                        user.bio?.let {
                            Text(
                                text = it,
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                            )
                        }
                    }

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
                                Text(text = "11 91234-5678",fontFamily = poppinsFamily)
                            }

                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 30.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_instagram),
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "@maria_eduarda",fontFamily = poppinsFamily)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Selos",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFamily,
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
                            contentDescription = "Selo ONG",
                            modifier = Modifier.size(80.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.selo_nutrir),
                            contentDescription = "Selo ONG",
                            modifier = Modifier.size(80.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Competências",
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
                        // Primeiro item de habilidades
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            if (user != null && user.abilities != null) {
                                user.abilities.forEach { ability ->
                                    CampaignListItem(ability.toString())
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(8.dp))

                }
            }
        },
        bottomBar = {
            BottomNavBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                navController = navController
            )
        }
    ) // Este parêntese fecha corretamente o Scaffold
}


@Composable
fun CampaignListItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
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
    //ProfileScreen(profileType = ProfileType.Ong, navController = navController)
}