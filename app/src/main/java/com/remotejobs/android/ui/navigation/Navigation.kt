package com.remotejobs.android.ui.navigation

import JobDetailsScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.remotejobs.android.ui.components.BottomNavBar
import com.remotejobs.android.ui.screens.AppliedJobsScreen
import com.remotejobs.android.ui.screens.JobsScreen
import com.remotejobs.android.ui.screens.ProfileScreen
import com.remotejobs.android.ui.screens.SavedJobsScreen
import com.remotejobs.android.ui.screens.SignInScreen
import com.remotejobs.android.ui.screens.SignUpScreen
import com.remotejobs.android.ui.screens.WelcomeScreen
import com.remotejobs.android.viewmodel.ProfileViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {

    val navController = rememberNavController()

    val auth = Firebase.auth

    val user = auth.currentUser

    val profileViewModel: ProfileViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = if (user == null) Welcome.route else DashBoard.route
    ) {
        composable(DashBoard.route) {
            BottomNavBar(navController = navController, user,profileViewModel)
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
            ProfileScreen(navController, user, profileViewModel)
        }
        composable(SavedJobs.route) {
            SavedJobsScreen()
        }

    }

}