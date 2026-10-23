package com.tomasreyes.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tomasreyes.facebook.ui.screens.FacebookLoginScreen
import com.tomasreyes.facebook.ui.screens.FacebookRegisterScreen
import com.tomasreyes.facebook.ui.theme.FacebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()
            NavHost(
                navController = myNavController,
                startDestination = Routes.LOGIN,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = Routes.LOGIN) {
                    FacebookLoginScreen(
                        onClickRegister = { myNavController.navigate(Routes.REGISTER) },
                        onClickIniciarSesion = { myNavController.navigate(Routes.FEED) {
                            popUpTo(route = Routes.LOGIN){
                                inclusive = true
                            }
                        } }

                    )
                }
                composable(Routes.REGISTER) {
                    FacebookRegisterScreen(onClickBack = { myNavController.popBackStack() })
                }
                composable(Routes.FEED) {

                }
            }
        }
    }
}