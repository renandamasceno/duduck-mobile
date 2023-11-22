package com.mobile.duduck.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.duduck.R

@Composable
fun MyBottomAppBar() {

    BottomAppBar(
        containerColor = colorResource(id = R.color.gray_dashboards_box),
        modifier = Modifier
            .clip(ShapeDefaults.ExtraLarge)
            .fillMaxWidth()
    ) {

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            },
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.budgets),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color.White
                )
            },
        )

        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            containerColor = colorResource(id = R.color.orange_duduck),
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null
            )
        }

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color.White
                )
            },
        )

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.credit_cards),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color.White
                )
            },
        )

    }
}

@Preview
@Composable
fun MyBottomAppBarPreview() {
    MyBottomAppBar()
}