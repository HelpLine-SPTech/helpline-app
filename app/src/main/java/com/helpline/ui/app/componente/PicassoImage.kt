package com.helpline.ui.app.componente

import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.helpline.R
import com.squareup.picasso.Picasso

@Composable
fun PicassoImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    AndroidView(
        factory = { context ->
            ImageView(context).apply {
                // Optional: Set some properties for the ImageView if needed
            }
        },
        update = { imageView ->
            // Load the image using Picasso
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.logo) // Optional: Placeholder image
                .error(R.drawable.logo) // Optional: Error image
                .fit()
                .into(imageView)
        },
        modifier = modifier
    )
}