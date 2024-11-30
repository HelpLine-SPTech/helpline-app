import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helpline.network.forum.Comment
import com.helpline.ui.app.componente.PicassoImage
import com.helpline.ui.app.componente.forum.poppinsFamily

@Composable
fun CommentItem(
    comment: Comment,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Imagem de perfil
        PicassoImage(
            imageUrl = comment.user.profilePicUrl ?: "",
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(48.dp) // Tamanho da imagem
                .clip(CircleShape) // Forma redonda
                .border(1.dp, Color.Gray, CircleShape) // Borda para destacar
        )

        Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre a imagem e os textos

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f) // Ocupa o espaço restante
        ) {
            Text(
                text = comment.user.name,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
            )
            Text(
                text = comment.content,
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
            )
        }
    }
}