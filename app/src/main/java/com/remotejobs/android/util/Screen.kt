package com.remotejobs.android.util

import androidx.compose.runtime.Composable

sealed class Screen (val screen: String){
    data object Home : Screen("home")
    data object Saved : Screen("saved")
    data object Applications : Screen("application")
    data object Profile : Screen("profile")
}