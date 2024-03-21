package com.remotejobs.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseUser
import com.remotejobs.android.R
import com.remotejobs.android.ui.components.ProfileAppBar

@Composable
fun ProfileScreen(navController: NavController, user: FirebaseUser?) {

    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        ProfileAppBar(title = "Profile", icon = R.drawable.backarrow) {
            navController.popBackStack()
        }
        Text(
            text = "User email: ${user?.email}",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Text(
            text = "User email: ${user?.isAnonymous}",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }

}