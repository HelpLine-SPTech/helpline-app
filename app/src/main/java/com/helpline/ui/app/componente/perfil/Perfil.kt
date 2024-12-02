package com.helpline.ui.app.componente.perfil

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.helpline.view.perfilong.poppinsFamily
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.helpline.R
import com.helpline.network.forum.Address
import com.helpline.network.forum.User


fun openWhatsApp(context: Context, phoneNumber: String) {
    val sanitizedNumber = phoneNumber.replace(Regex("[^\\d]"), "")

    // Garante que o número tenha pelo menos 11 dígitos (código do país + DDD + número)
    if (sanitizedNumber.length < 11) {
        // Lógica para tratar números incompletos
        // Toast.makeText(context, "Número de telefone inválido", Toast.LENGTH_SHORT).show()
        return
    }

    val message = "Olá, gostaria de conversar com você sobre campanhas futuras. Encontrei seu número " +
            "no aplicativo Helpline!"

    // Adiciona o código do país se estiver ausente (assumindo +55 para Brasil)
    val formattedNumber = if (!sanitizedNumber.startsWith("55")) {
        "55$sanitizedNumber"
    } else {
        sanitizedNumber
    }

    val url = "https://wa.me/55${phoneNumber.replace(" ", "").replace("-", "")}?text=${message}"
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
        setPackage("com.whatsapp")
    }
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "WhatsApp não instalado", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun WhatsAppRow(phoneNumber: String) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { openWhatsApp(context, phoneNumber) }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_zap),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = phoneNumber, fontFamily = poppinsFamily)
    }
}

fun openMaps(context: Context, address: String) {
    val geoUri = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
    val intent = Intent(Intent.ACTION_VIEW, geoUri)
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        // Feedback ao usuário, caso não haja nenhum app de mapas
        // Toast.makeText(context, "Nenhum aplicativo de mapas encontrado", Toast.LENGTH_SHORT).show()
    }
}


fun formatAddress(address: String): String {
    val regex = Regex("""Address\(.*?\)""")
    val matchResult = regex.find(address)?.value ?: return address

    val fields = matchResult
        .removePrefix("Address(")
        .removeSuffix(")")
        .split(", ")
        .associate {
            val (key, value) = it.split("=")
            key to value
        }

    return """
        ${fields["street"]}, ${fields["number"]} ${fields["complement"]?.let { "- $it" } ?: ""}
        ${fields["neighborhood"]}, ${fields["city"]} - ${fields["state"]}
        CEP: ${fields["zipCode"]}
    """.trimIndent()
}



@Composable
fun AddressRow(user: User?) {
    val context = LocalContext.current
    var showModal by remember { mutableStateOf(false) }

    val formattedAddress = user?.address?.let { formatAddress(it.toString()) } ?: ""

    // Linha de endereço clicável
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { showModal = true }
    ) {
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

    // Modal para exibir a escolha de mapas
    if (showModal) {
        AlertDialog(
            onDismissRequest = { showModal = false },
            title = { Text(text = "Abrir endereço") },
            text = { Text("Deseja abrir o endereço em um aplicativo de mapas?") },
            confirmButton = {
                Button(onClick = {
                    if (user != null) {
                        openMaps(context, formattedAddress)
                    }
                    showModal = false
                },colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF25472B),
                    contentColor = Color.White // Cor do texto no botão
                )
                ) {
                    Text("Abrir")
                }
            }, 
            dismissButton = {
                Button(
                    onClick = { showModal = false },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF25472B),
                        contentColor = Color.White
                )
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}