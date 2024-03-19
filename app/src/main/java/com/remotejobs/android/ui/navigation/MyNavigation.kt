package com.remotejobs.android.ui.navigation

import JobDetailsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DetailsScreen.route
    ) {
        composable(DetailsScreen.route) {
            JobDetailsScreen()
        }
    }

}