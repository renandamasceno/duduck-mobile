package com.mobile.duduck.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.duduck.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDefault(title: String, navController: NavController?) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.gray_appbar_title),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent

        ),
        navigationIcon = {
            if(navController == null) return@TopAppBar
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back),
                    contentDescription = null,
                    tint = colorResource(id = R.color.gray_appbar_title)
                )
            }
        }
    )
}

@Preview
@Composable
fun ToAppBarPreview() {
    TopAppBarDefault(title = stringResource(R.string.payment_title), null)
}