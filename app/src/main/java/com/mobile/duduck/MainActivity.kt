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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobile.duduck.ui.theme.DuduckTheme
import com.mobile.duduck.view.CardScreenDashboard
import com.mobile.duduck.view.DashboardActivity
import com.mobile.duduck.view.LoginActivity
import com.mobile.duduck.view.LoginScreen
import com.mobile.duduck.view.SignupActivity
import com.mobile.duduck.view.SignupScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuduckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.black_background)
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(navController = navController)
                        }
                        composable("login") {
                            LoginScreen(navController = navController)
                        }
                        composable("signup") {
                            SignupScreen(navController = navController)
                        }
                        composable("dashboard") {
                            CardScreenDashboard(navController = navController)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {

    Image(
        painter = painterResource(id = R.drawable.splash_screen),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.8f)
            .scale(1.0f),
        contentScale = ContentScale.Crop
    )

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(route = "login")
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
//    SplashScreen()
}
