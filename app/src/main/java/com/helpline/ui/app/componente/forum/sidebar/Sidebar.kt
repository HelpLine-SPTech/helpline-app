package com.helpline.ui.app.componente.forum.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.helpline.config.Session
import com.helpline.ui.app.componente.PicassoImage
import com.helpline.ui.app.componente.header.TopBar
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


@Composable
fun NavDrawer(
  drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
  navController: NavController,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit,
) {

  val scope = rememberCoroutineScope()

  ModalNavigationDrawer(
    drawerContent = {
      ModalDrawerSheet(
        modifier = Modifier.background(Color.White) // Fundo branco e sem borda preta
      ) {
        Column(
          Modifier
            .fillMaxSize()
            .background(Color.White),
          verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
          SidebarContent(navController)
        }
      }
    },
    drawerState = drawerState
  ) {
    content()
    TopBar(onMenuClick = {
      scope.launch { drawerState.open() }
    })
  }
}

@Composable
fun SidebarContent(navController: NavController) {

  val session: Session by inject(Session::class.java)

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .background(Color.White)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(bottom = 24.dp, top = 32.dp)
    ) {
      PicassoImage(
        imageUrl = session.loggedUser?.profilePicUrl ?: "",
        contentDescription = "Profile Image",
        modifier = Modifier
          .size(84.dp)
          .clip(CircleShape)
      )
      Spacer(modifier = Modifier.width(16.dp))
      Column {
        session.loggedUser?.let {
          Text(
            text = it.name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
          )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "Ver perfil",
          color = Color.Gray,
          fontSize = 14.sp,
//          modifier = Modifier.clickable { navController.navigate("profileScreenVolunteer") },
        )
      }
    }

    // Divider
    HorizontalDivider(
      modifier = Modifier.padding(vertical = 8.dp),
      color = Color.LightGray
    )

    // Itens do menu
    DrawerItem(icon = Icons.Default.Home, label = "Início", route = "forumScreen", navController = navController)
    DrawerItem(icon = Icons.AutoMirrored.Filled.Chat, label = "Chat", route = "chat-list", navController = navController)
    DrawerItem(icon = Icons.Default.Work, label = "Vagas", route = "jobs", navController = navController)

    Spacer(modifier = Modifier.weight(1f))

    // Botão de sair
    DrawerItem(icon = Icons.AutoMirrored.Filled.Logout, label = "Sair", isLogout = true, route = "loginPage", navController = navController)
  }
}

@Composable
fun DrawerItem(icon: ImageVector, route: String, label: String, isLogout: Boolean = false, navController: NavController) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 10.dp)
      .clickable {
        navController.navigate(route)
      }
  ) {
    Icon(
      imageVector = icon,
      contentDescription = label,
      modifier = Modifier.size(40.dp),
      tint = Color.Black
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(
      text = label,
      fontWeight = if (isLogout) FontWeight.SemiBold else FontWeight.Normal,
      color = if (isLogout) Color.Black else Color.Gray,
      fontSize = if (isLogout) 18.sp else 16.sp,
    )
  }
}
