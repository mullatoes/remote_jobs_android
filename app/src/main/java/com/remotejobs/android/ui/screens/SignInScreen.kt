package com.remotejobs.android.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.remotejobs.android.ui.components.ButtonComponent
import com.remotejobs.android.ui.components.CreateAnAccountComponent
import com.remotejobs.android.ui.components.LoginEmailComponent
import com.remotejobs.android.ui.components.LoginPasswordComponent
import com.remotejobs.android.ui.navigation.DashBoard
import com.remotejobs.android.ui.navigation.Jobs

@Composable
fun SignInScreen(navController: NavController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    Column {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Text(
            text = "Log In",
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Welcome Back",
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        LoginEmailComponent(
            label = "email",
            placeholder = "email",
            email = email,
            onEmailChange = { email = it })
        LoginPasswordComponent(
            label = "password",
            placeholder = "password",
            password = password,
            onPasswordChange = { password = it })
        Text(
            text = "Forgot password?",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal
        )
        ButtonComponent(buttonClick = {
            isLoading = true
            signInWithEmailAndPassword(email, password) { isSuccess ->
                if (isSuccess) {
                    navController.navigate(DashBoard.route)
                } else {
                    println("Authentication failed")
                }
                isLoading = false
            }
        }, text = "Sign In")

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

fun signInWithEmailAndPassword(email: String, password: String, onComplete: (Boolean) -> Unit) {
    Firebase.auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onComplete(true)
            } else {
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                onComplete(false)
            }
        }
}
