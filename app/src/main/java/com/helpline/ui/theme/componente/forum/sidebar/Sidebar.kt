package com.helpline.ui.theme.componente.forum.sidebar

//@Composable
//fun NavDrawer(
//  drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
//  content: @Composable () -> Unit
//) {
//
//  val scope = rememberCoroutineScope()
//
//  ModalNavigationDrawer(
//    drawerContent = {
//      ModalDrawerSheet(
//        modifier = Modifier.background(Color.White) // Fundo branco e sem borda preta
//      ) {
//        Column(
//          Modifier
//            .fillMaxSize()
//            .background(Color.White),
//          verticalArrangement = Arrangement.spacedBy(12.dp),
//        ) {
//          SidebarContent()
//        }
//      }
//    },
//    drawerState = drawerState
//  ) {
//    content()
//    TopBar(onMenuClick = {
//      scope.launch { drawerState.open() }
//    })
//  }
//}

//@Composable
//fun SidebarContent() {
//  Column(
//    modifier = Modifier
//      .fillMaxSize()
//      .padding(16.dp)
//      .background(Color.White)
//  ) {
//    Row(
//      verticalAlignment = Alignment.CenterVertically,
//      modifier = Modifier.padding(bottom = 24.dp, top = 32.dp)
//    ) {
//      Image(
//        painter = painterResource(id = R.mipmap.imgperfil),
//        contentDescription = "Profile Image",
//        modifier = Modifier
//          .size(84.dp)
//          .clip(CircleShape)
//      )
//      Spacer(modifier = Modifier.width(16.dp))
//      Column {
//        Text(
//          text = "Rafael Oliveira",
//          fontWeight = FontWeight.Bold,
//          fontSize = 20.sp,
//          color = Color.Black
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(
//          text = "Ver perfil",
//          color = Color.Gray,
//          fontSize = 14.sp
//        )
//      }
//    }
//
//    // Divider
//    HorizontalDivider(
//      modifier = Modifier.padding(vertical = 8.dp),
//      color = Color.LightGray
//    )
//
//    // Itens do menu
//    DrawerItem(icon = Icons.Default.Home, label = "Início")
//    DrawerItem(icon = Icons.AutoMirrored.Filled.Chat, label = "Chat")
//    DrawerItem(icon = Icons.Default.Work, label = "Vagas")
//
//    Spacer(modifier = Modifier.weight(1f))
//
//    // Botão de sair
//    DrawerItem(icon = Icons.AutoMirrored.Filled.Logout, label = "Sair", isLogout = true)
//  }
//}

//@Composable
//fun DrawerItem(icon: ImageVector, label: String, isLogout: Boolean = false) {
//  val navController = NavController(context = context)
//
//  Row(
//    verticalAlignment = Alignment.CenterVertically,
//    modifier = Modifier
//      .fillMaxWidth()
//      .padding(vertical = 10.dp)
//      .clickable {
//        if (isLogout) {
//          navController.navigate("loginPage")
//        } else {
//          navController.navigate("forumScreen")
//        }
//      }
//  ) {
//    Icon(
//      imageVector = icon,
//      contentDescription = label,
//      modifier = Modifier.size(40.dp),
//      tint = Color.Black
//    )
//    Spacer(modifier = Modifier.width(16.dp))
//    Text(
//      text = label,
//      fontWeight = if (isLogout) FontWeight.SemiBold else FontWeight.Normal,
//      color = if (isLogout) Color.Black else Color.Gray,
//      fontSize = if (isLogout) 18.sp else 16.sp
//    )
//  }
//}
