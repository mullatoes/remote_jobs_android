package com.remotejobs.android.ui.navigation

interface Destinations {
    val route: String
}

object DetailsScreen : Destinations{
    override val route: String
        get() = "JobDetailsScreen"

}