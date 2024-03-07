package com.remotejobs.android.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.remotejobs.android.ui.components.ButtonComponent
import com.remotejobs.android.ui.components.CreateAnAccountComponent
import com.remotejobs.android.ui.components.LoginEmailComponent
import com.remotejobs.android.ui.components.LoginPasswordComponent

@Composable
fun RegisterScreen(navController: NavController) {

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
            text = "Create an account",
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Join the community",
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
            onEmailChange = {
                email = it
            })
        LoginPasswordComponent(
            label = "password",
            placeholder = "password",
            password = password,
            onPasswordChange = {
                password = it
            })
        Text(
            text = "Forgot password?",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal
        )
        ButtonComponent(buttonClick = {
            createUserWithEmailPassword(navController, email, password)
        }, text = "Create account")
    }
}

private lateinit var auth: FirebaseAuth
fun createUserWithEmailPassword(navController: NavController, email: String, password: String) {

    auth = Firebase.auth

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                navController.navigate("jobs_screen")
            } else {
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                Toast.makeText(
//                    LocalContext.current,
//                    "Authentication failed.",
//                    Toast.LENGTH_SHORT,
//                ).show()

            }
        }
}
