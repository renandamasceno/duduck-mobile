package com.mobile.duduck.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.duduck.R

@Composable
fun BoxDashboard(textValue: String, priceTextValue: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(4.dp)
        ) {
        Card(
            modifier = Modifier
                .height(68.dp)
                .width(104.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.gray_dashboards_box)
            )
        ) {
            Text(
                text = textValue,
                color = colorResource(id = R.color.gray_dashboard_fields_duduck),
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = priceTextValue,
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(1.dp)
                    .align(CenterHorizontally)
            )
        }
    }

}

@Preview
@Composable
fun BoxDashboardPreview() {
    BoxDashboard(
        textValue = stringResource(R.string.active_subscriptions_txt),
        priceTextValue = "R$24,99"
    )
}