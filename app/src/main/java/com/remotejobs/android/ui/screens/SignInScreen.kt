package com.remotejobs.android.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun SignInScreen(navController: NavController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
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
            signInWithEmailAndPassword(navController, email, password)
        }, text = "Sign In")
        CreateAnAccountComponent(onClick = { navController.navigate("register_screen") }, text = "")
    }
}

fun signInWithEmailAndPassword(navController: NavController, email: String, password: String) {
    Firebase.auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "signInWithEmail:success")
                val user = Firebase.auth.currentUser
                navController.navigate("job_screen")
            } else {

                Log.w(TAG, "signInWithEmail:failure", task.exception)

            }
        }
}
