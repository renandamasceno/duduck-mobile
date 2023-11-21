package com.mobile.duduck.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.duduck.R
import com.mobile.duduck.ui.theme.DuduckTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.gray_textfields_duduck)
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {

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
            CheckboxDefault()

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
                    text = stringResource(R.string.enter_field_txt),
                    color = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDefault(label: String) {
    var textValue by remember {
        mutableStateOf("")
    }

    TextField(
        value = textValue,
        label = {
            Text(
                text = label,
                color = colorResource(id = R.color.gray_textfields_duduck)
            )
        },
        shape = MaterialTheme.shapes.large,
        singleLine = true,
        onValueChange = { newText ->
            textValue = newText
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = MaterialTheme.shapes.large,
                color = colorResource(id = R.color.gray_textfields_duduck)
            )
    )
}

@Composable
fun CheckboxDefault() {
    var checkedValue by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Checkbox(
            checked = checkedValue,
            onCheckedChange = { newClick ->
                checkedValue = newClick
            },
            modifier = Modifier
                .background(
                    color = Color.Transparent,
                    shape = MaterialTheme.shapes.large
                ),
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(id = R.color.orange_duduck)
            )
        )
        Text(
            text = stringResource(R.string.remember_me_field_txt),
            color = colorResource(id = R.color.gray_textfields_duduck)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.forgot_password_txt),
            color = colorResource(id = R.color.gray_textfields_duduck),
            textDecoration = TextDecoration.Underline,
        )
    }
}

@Preview
@Composable
fun LoginActivityPreview() {
    DuduckTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(color = R.color.black_background)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoginScreen()
            }
        }

    }
}