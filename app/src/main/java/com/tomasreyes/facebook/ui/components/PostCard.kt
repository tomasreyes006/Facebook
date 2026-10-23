package com.tomasreyes.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    userName: String = "Tomas Reyes",
    timeAgo: String = "Hace 15 min",
    postText: String = "Por fin terminé la pantalla de login en Compose",
    imageUrl: String? = "https://picsum.photos/600/400",
    likesCount: Int = 24,
    commentsCount: Int = 3,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        PostHeader(
            userName = userName,
            timeAgo = timeAgo,
        )

        Text(
            text = postText,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )

        if (!imageUrl.isNullOrEmpty()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Imagen de la publicación",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        PostStats(
            likesCount = likesCount,
            commentsCount = commentsCount,
        )

        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.LightGray,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        PostAction()
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}
