package com.mobile.duduck.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.duduck.R
import com.mobile.duduck.view.components.TextFieldDefault
import com.mobile.duduck.view.ui.theme.DuduckTheme

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.black_background)
                ) {
                    SignupScreen()
                }
            }
        }
    }
}

@Composable
fun SignupScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.duduck_logo),
            contentDescription = stringResource(R.string.duduck_logo_txt),
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 256.dp),
            verticalArrangement = Arrangement.Center
        ) {

            TextFieldDefault(label = stringResource(R.string.e_mail_field_txt))
            TextFieldDefault(label = stringResource(R.string.password_field_txt))
            TextFieldDefault(label = stringResource(R.string.repeat_password_field_txt))

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
                    text = stringResource(R.string.register_field_txt),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun SignupActivityPreview() {
    DuduckTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.black_background)
        ) {
            SignupScreen()
        }
    }
}