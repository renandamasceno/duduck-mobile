package com.mobile.duduck.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.duduck.R
import com.mobile.duduck.view.components.MyBottomAppBar
import com.mobile.duduck.view.components.TopAppBarDefault
import com.mobile.duduck.view.ui.theme.DuduckTheme

class PaymentsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.black_background)
                ) {
                    ContentScreenPayment()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreenPayment(navController: NavController? = null) {
    Scaffold(
        topBar = {
            TopAppBarDefault(title = stringResource(R.string.payment_title), navController = navController)
        },
        bottomBar = { MyBottomAppBar() },
        containerColor = colorResource(id = R.color.black_background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .width(280.dp)
                    .height(380.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.credit_card_background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.8f)
                        .scale(1.0f),
                    contentScale = ContentScale.Crop
                )
            }

            OutlinedButton(
                onClick = { /*TODO*/ },
            ) {
                Text(
                    text = stringResource(R.string.add_new_card_txt),
                    color = colorResource(id = R.color.gray_appbar_title)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
                    contentDescription = null,
                    tint = colorResource(id = R.color.gray_appbar_title),
                    modifier = Modifier
                        .padding(start = 2.dp)
                        .scale(0.8f)
                )
            }
        }
    }
}

@Preview
@Composable
fun PaymentsActivityPreview() {
    DuduckTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.black_background)
        ) {
            ContentScreenPayment()
        }
    }
}