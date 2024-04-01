package com.remotejobs.android.ui.navigation

import JobDetailsScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.remotejobs.android.ui.components.BottomNavBar
import com.remotejobs.android.ui.screens.NewsScreen
import com.remotejobs.android.ui.screens.JobsScreen
import com.remotejobs.android.ui.screens.ProfileScreen
import com.remotejobs.android.ui.screens.UserBookmarkedJobsScreen
import com.remotejobs.android.ui.screens.SignInScreen
import com.remotejobs.android.ui.screens.SignUpScreen
import com.remotejobs.android.ui.screens.WelcomeScreen
import com.remotejobs.android.viewmodel.JobViewModel
import com.remotejobs.android.viewmodel.ProfileViewModel
import com.remotejobs.android.viewmodel.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    userViewModel: UserViewModel,
    profileViewModel: ProfileViewModel,
    jobViewModel: JobViewModel
) {

    val navController = rememberNavController()

    val auth = Firebase.auth
    val user = auth.currentUser

    userViewModel.setUser(user)

    NavHost(
        navController = navController,
        startDestination = if(user != null) DashBoard.route else SignIn.route
    ) {
        composable(DashBoard.route) {
            BottomNavBar(navController = navController,profileViewModel, jobViewModel,userViewModel)
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
            NewsScreen()
        }
        composable(Jobs.route) {
            JobsScreen(userViewModel)
        }
        composable(Profile.route) {
            ProfileScreen(navController, profileViewModel, userViewModel)
        }
        composable(SavedJobs.route) {
            UserBookmarkedJobsScreen(navController,jobViewModel, userViewModel)
        }

    }

}