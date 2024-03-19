package com.remotejobs.android.ui.navigation

import JobDetailsScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.remotejobs.android.ui.components.BottomNavBar
import com.remotejobs.android.ui.screens.SignInScreen
import com.remotejobs.android.ui.screens.RegisterScreen
import com.remotejobs.android.ui.screens.WelcomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "jobs_screen") {
        composable("welcome_screen") {
            WelcomeScreen(navController)
        }
        composable("register_screen") {
            RegisterScreen(navController)
        }
        composable("login_screen") {
            SignInScreen(navController)
        }
        composable("jobs_screen") {
            BottomNavBar()
        }
        composable("job_details_screen"){
            JobDetailsScreen()
        }
    }
}