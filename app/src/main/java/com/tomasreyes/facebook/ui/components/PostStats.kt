package com.tomasreyes.facebook.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FacebookGray = Color(0xFF65676B)

@Composable
fun PostStats(
    modifier: Modifier = Modifier,
    likesCount: Int = 24,
    commentsCount: Int = 3,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Reacción e indicador de cantidad de Me gusta
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "👍",
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "$likesCount",
                color = FacebookGray,
                fontSize = 14.sp,
            )
        }

        // Cantidad de comentarios a la derecha
        Text(
            text = "$commentsCount comentarios",
            color = FacebookGray,
            fontSize = 14.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostStatsPreview() {
    PostStats(
        likesCount = 24,
        commentsCount = 3,
    )
}
