package com.mobile.duduck.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mobile.duduck.R

@Composable
fun ItemListSubscription(
    subscriptionImage: String?,
    subscriptionName: String?,
    subscriptionPrice: String?,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(
            2.dp,
            colorResource(id = R.color.gray_background_secundary_duduck)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
        ) {
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .padding(8.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                AsyncImage(
                    model = subscriptionImage,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.spotify_example),
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(14.dp))
                )
            }
            Text(
                text = subscriptionName.toString(),
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(start = 8.dp)
            )
            Text(
                text = subscriptionPrice.toString(),
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(end = 8.dp)
                    .weight(1f)
                    .wrapContentWidth(End)
            )
        }
    }
}

@Preview
@Composable
fun ItemListSubscriptionPreview() {
    ItemListSubscription(
        subscriptionImage = null,
        subscriptionName = "Spotify",
        subscriptionPrice = "R$22,00"
    )
}