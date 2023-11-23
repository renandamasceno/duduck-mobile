package com.mobile.duduck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobile.duduck.ui.theme.DuduckTheme
import com.mobile.duduck.view.DashboardActivity
import com.mobile.duduck.view.LoginActivity
import com.mobile.duduck.view.SignupActivity
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            MainActivity()
                        }
                        composable("login") {
                            LoginActivity()
                        }
                        composable("signup") {
                            SignupActivity()
                        }
                        composable("dashboard") {
                            DashboardActivity()
                        }
                    }
                    SplashScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("login")
    }

    Image(
        painter = painterResource(id = R.drawable.splash_screen),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.8f)
            .scale(1.0f),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun SplashScreenPreview() {
//    SplashScreen()
}
