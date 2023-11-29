package com.mobile.duduck.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mobile.duduck.R

@Composable
fun ItemListAddSubscription(imageURL: String?, subscriptionName: String?) {
    Column(
        modifier = Modifier
            .height(150.dp)
            .width(120.dp)
            .padding(4.dp)
    ) {
        AsyncImage(
            model = imageURL.toString(),
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.spotify_example),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .clip(ShapeDefaults.ExtraLarge)
        )

        Text(
            text = subscriptionName.toString(),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.1f)
                .padding(4.dp)
                .align(CenterHorizontally)
        )
    }

}

@Preview
@Composable
fun ItemListAddPreview() {
    ItemListAddSubscription(imageURL = null, subscriptionName = "Spotify")
}