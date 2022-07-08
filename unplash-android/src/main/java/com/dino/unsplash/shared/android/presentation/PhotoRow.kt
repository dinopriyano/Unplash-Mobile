package com.dino.unsplash.shared.android.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.dino.unsplash.shared.android.theme.Dimesion
import com.dino.unsplash.shared.domain.model.Photo
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun PhotoRow(
    photo: Photo,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(Dimesion.SIZE_8),
        modifier = modifier
            .fillMaxWidth()
            .height(Dimesion.SIZE_200)
    ) {
        Image(
            painter = rememberCoilPainter(request = photo.urls.small),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}