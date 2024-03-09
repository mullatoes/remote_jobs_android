package com.remotejobs.android.util

import com.remotejobs.android.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var route: String
) {
    object Jobs :
        BottomNavItem(
            "Jobs",
            R.drawable.ic_android_black_24dp,
            "jobs_screen"
        )

    object Saved :
        BottomNavItem(
            "Saved",
            R.drawable.ic_android_black_24dp,
            "saved_route"
        )

    object Applications :
        BottomNavItem(
            "Applications",
            R.drawable.ic_android_black_24dp,
            "applied_route"
        )

    object Profile :
        BottomNavItem(
            "Profile",
            R.drawable.ic_android_black_24dp,
            "profile_route"
        )
}