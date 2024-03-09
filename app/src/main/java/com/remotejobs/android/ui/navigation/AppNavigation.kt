package com.remotejobs.android.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.remotejobs.android.ui.screens.JobsScreen
import com.remotejobs.android.ui.screens.SignInScreen
import com.remotejobs.android.ui.screens.RegisterScreen
import com.remotejobs.android.ui.screens.WelcomeScreen
import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "jobs_screen") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("register_screen") {
            RegisterScreen(navController)
        }
        composable("login_screen") {
            SignInScreen(navController)
        }
        composable("jobs_screen") {
            val viewModel: JobViewModel = viewModel()
            JobsScreen(viewModel = viewModel)
        }
    }
}