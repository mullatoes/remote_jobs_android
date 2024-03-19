package com.remotejobs.android.ui.navigation

interface Destinations {
    val route: String
}

object DashBoard : Destinations{
    override val route: String
        get() = "DASHBOARDSCREEN"
}

object Details : Destinations{
    override val route: String
        get() = "JOBDETAILSSCREEN"
}

object Welcome : Destinations {
    override val route: String
        get() = "WELCOMESCREEN"
}

object SignIn : Destinations {
    override val route: String
        get() = "SIGNINSCREEN"
}

object SignUp : Destinations {
    override val route: String
        get() = "SIGNUPSCREEN"
}

object AppliedJobs : Destinations {
    override val route: String
        get() = "APPLIEDJOBSSCREEN"
}

object Jobs : Destinations {
    override val route: String
        get() = "JOBSSCREEN"
}

object Profile : Destinations {
    override val route: String
        get() = "PROFILESCREEN"
}

object SavedJobs : Destinations {
    override val route: String
        get() = "SAVEDJOBSSCREEN"
}

