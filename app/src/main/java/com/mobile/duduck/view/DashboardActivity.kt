package com.mobile.duduck.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.duduck.R
import com.mobile.duduck.view.components.BoxDashboard
import com.mobile.duduck.view.ui.theme.DuduckTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.black_background)
                ) {
                    CardScreenDashboard()
                }
            }
        }
    }
}

@Composable
fun CardScreenDashboard() {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Card(
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 16.dp,
                bottomEnd = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.gray_background_secundary_duduck)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { TODO() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = stringResource(R.string.settings_icon_txt),
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopEnd)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Velocimeter(
                        value = 20f,
                        maxValue = 100f,
                        textValue = "R$22,00"
                    )

                    Row {
                        BoxDashboard(
                            textValue = stringResource(id = R.string.active_subscriptions_txt),
                            priceTextValue = "R$22"
                        )
                        BoxDashboard(
                            textValue = stringResource(id = R.string.most_expensive_subscriptions_txt),
                            priceTextValue = "R$22"
                        )
                        BoxDashboard(
                            textValue = stringResource(id = R.string.cheapest_subscriptions_txt),
                            priceTextValue = "R$22"
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun Velocimeter(
    value: Float,
    maxValue: Float,
    modifier: Modifier = Modifier,
    textValue: String
) {
    val progress = value / maxValue

    Box(
        modifier = modifier
            .size(200.dp)
            .background(color = Color.Transparent, CircleShape)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val textStyle = TextStyle(
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        val textMeasurer = rememberTextMeasurer()
        val textLayoutResult = remember(textValue) {
            textMeasurer.measure(textValue, textStyle)
        }
        val colorProgress = colorResource(id = R.color.orange_duduck)
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawArc(
                    color = Color.Gray,
                    startAngle = 135f,
                    sweepAngle = 270f,
                    useCenter = false,
                    size = size,
                    style = Stroke(width = 16f)
                )

                drawArc(
                    color = colorProgress,
                    startAngle = 135f,
                    sweepAngle = 270f * progress,
                    useCenter = false,
                    size = size,
                    style = Stroke(width = 16f)
                )

                drawText(
                    textMeasurer = textMeasurer,
                    text = textValue,
                    style = textStyle,
                    topLeft = Offset(
                        x = center.x - textLayoutResult.size.width / 2,
                        y = center.y - textLayoutResult.size.height / 2,
                    ),
                )

            }
        )

        Text(
            text = stringResource(R.string.month_expenses_txt),
            color = colorResource(id = R.color.gray_dashboard_fields_duduck),
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 60.dp)
        )
    }
}

@Preview
@Composable
fun DashboardActivityPreview() {
    DuduckTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.black_background)
        ) {
            CardScreenDashboard()
        }
    }
}