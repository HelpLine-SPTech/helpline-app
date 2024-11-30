package com.helpline.view.vaga

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.helpline.R
import com.helpline.network.vaga.Job
import com.helpline.ui.app.componente.forum.sidebar.NavDrawer
import com.helpline.ui.app.componente.footer.BottomNavBar
import com.helpline.ui.theme.componente.vaga.CardVagas
import com.helpline.viewmodel.vaga.VagaViewModel

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VagaScreen (navController: NavController, vagaViewModel: VagaViewModel){
    val jobs = remember { mutableStateListOf<Job>()}

    LaunchedEffect(Unit) {
        vagaViewModel.getVagaPorId(
            onSuccess = { response ->
                Log.d("VAGAS RESPOSTA", response.toString())
                jobs.addAll(response.jobs)
            },
            onFailure = { error ->

            })
    }

    // menu lateral
    NavDrawer(navController = navController) {
        Scaffold(
            content = {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Conteúdo principal que rola
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                bottom = 60.dp,
                                top = 120.dp
                            ) // Espaçamento para evitar sobreposição com o footer
                    ) {
                        items(jobs) {
                            CardVagas(job = it)
                        }

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
}
