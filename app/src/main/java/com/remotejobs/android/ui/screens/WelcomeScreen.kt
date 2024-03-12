package com.remotejobs.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.remotejobs.android.R
import com.remotejobs.android.ui.components.ButtonComponent
import com.remotejobs.android.ui.components.CreateAnAccountComponent
import com.remotejobs.android.ui.components.TwoRowImagesComponent

@Composable
fun WelcomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(5.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Text(
            text = "Remote",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        Text(
            text = "Welcome to Remote",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        Text(
            text = "Find the best job opportunities,",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Text(
            text = "connect with companies and get hired fast.",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Spacer(
            modifier = Modifier
                .height(40.dp)
        )
        TwoRowImagesComponent(
            R.drawable.work_from_anywhere,
            R.drawable.remote,
            leftText = "Work from anywhere",
            rightText = "Connect with top companies"
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        TwoRowImagesComponent(
            R.drawable.hired,
            R.drawable.reliable,
            leftText = "Get hired fast",
            rightText = "Fast & reliable"
        )
        Spacer(
            modifier = Modifier
                .height(30.dp)
        )
        ButtonComponent(buttonClick = { navController.navigate("login_screen") }, text = "Sign In")
        Spacer(
            modifier = Modifier
                .height(30.dp)
        )
        CreateAnAccountComponent(onClick = { navController.navigate("register_screen") }, text = "Create an account")
    }

}