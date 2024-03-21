package com.remotejobs.android.ui.navigation

import JobDetailsScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.remotejobs.android.ui.components.BottomNavBar
import com.remotejobs.android.ui.screens.AppliedJobsScreen
import com.remotejobs.android.ui.screens.JobsScreen
import com.remotejobs.android.ui.screens.ProfileScreen
import com.remotejobs.android.ui.screens.SavedJobsScreen
import com.remotejobs.android.ui.screens.SignInScreen
import com.remotejobs.android.ui.screens.SignUpScreen
import com.remotejobs.android.ui.screens.WelcomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Welcome.route
    ) {
        composable(DashBoard.route) {
            BottomNavBar(navController = navController)
        }
        composable(Details.route) {
            JobDetailsScreen()
        }
        composable(Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(SignIn.route) {
            SignInScreen(navController = navController)
        }
        composable(SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(AppliedJobs.route) {
            AppliedJobsScreen()
        }
        composable(Jobs.route) {
            JobsScreen(navController = navController)
        }
        composable(Profile.route) {
            ProfileScreen()
        }
        composable(SavedJobs.route) {
            SavedJobsScreen()
        }

    }

}