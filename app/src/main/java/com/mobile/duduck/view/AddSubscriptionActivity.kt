package com.mobile.duduck.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.duduck.R
import com.mobile.duduck.model.Subscription
import com.mobile.duduck.view.components.ItemListAddSubscription
import com.mobile.duduck.view.components.TextFieldDefault
import com.mobile.duduck.view.components.TopAppBarDefault
import com.mobile.duduck.view.ui.theme.DuduckTheme

class AddSubscriptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.black_background)
                ) {
                    ScreenAddSubscription(subscriptions = Subscription().exampleList())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenAddSubscription(subscriptions: List<Subscription>) {
    Scaffold(
        topBar = { TopAppBarDefault(title = stringResource(R.string.add_subscription_title_txt)) },
        containerColor = colorResource(id = R.color.black_background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.gray_background_secundary_duduck)
                ),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 18.dp,
                    bottomEnd = 18.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.add_subscription_txt),
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 100.dp)
                )

                Spacer(modifier = Modifier.padding(top = 30.dp))

                LazyRow() {
                    items(subscriptions) { subscription ->
                        ItemListAddSubscription(
                            imageURL = subscription.image,
                            subscriptionName = subscription.name
                        )
                        Spacer(modifier = Modifier.padding(18.dp))
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .padding(horizontal = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.description_name_txt),
                    color = colorResource(id = R.color.gray_textfields_duduck),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
                TextFieldDefault()

                val gradientBrush = Brush.radialGradient(
                    colors = listOf(
                        colorResource(id = R.color.white),
                        colorResource(id = R.color.orange_duduck)
                    ),
                    center = Offset(0.5f, 0.5f),
                    radius = 0.5f,
                    tileMode = TileMode.Clamp
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(8.dp)
                        .background(gradientBrush, shape = MaterialTheme.shapes.extraLarge)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = stringResource(R.string.add_subscription_btn_txt),
                        color = Color.White
                    )
                }
            }
        }

    }
}


@Preview
@Composable
fun ScreenAddSubscriptionPreview() {
    ScreenAddSubscription(subscriptions = Subscription().exampleList())
}
