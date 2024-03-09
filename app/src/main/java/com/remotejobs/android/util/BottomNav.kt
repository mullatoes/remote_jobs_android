package com.remotejobs.android.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.remotejobs.android.ui.screens.AppliedJobsScreen
import com.remotejobs.android.ui.screens.JobsScreen
import com.remotejobs.android.ui.screens.ProfileScreen
import com.remotejobs.android.ui.screens.SavedJobsScreen
import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavigation() {

    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem.Jobs,
        BottomNavItem.Saved,
        BottomNavItem.Applications,
        BottomNavItem.Profile
    )

    val viewModel: JobViewModel = viewModel()

    NavHost(navController, startDestination = items.first().route) {

        items.forEach { item ->
            composable(item.route) {

                when (item) {
                    BottomNavItem.Jobs -> JobsScreen(viewModel)
                    BottomNavItem.Saved -> SavedJobsScreen(navController)
                    BottomNavItem.Applications -> AppliedJobsScreen(navController)
                    BottomNavItem.Profile -> ProfileScreen(navController)
                }
            }
        }
    }

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    navController: NavController
) {

    NavigationBarItem(

        label = {
            Text(text = screen.title)
        },

        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },

        selected = true,

        alwaysShowLabel = true,

        onClick = {
            println("Clicked")
            navController.navigate("jobs_screen")
        },

        colors = NavigationBarItemDefaults.colors()
    )
}