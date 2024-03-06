package com.remotejobs.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.remotejobs.android.ui.components.TwoRowImagesComponent
import com.remotejobs.android.ui.screens.LoginScreen
import com.remotejobs.android.ui.screens.WelcomeScreen
import com.remotejobs.android.ui.theme.RemoteJobsTheme
import com.remotejobs.android.viewmodel.JobViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteJobsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: JobViewModel = viewModel()
                  // JobsScreen(viewModel = viewModel)
                  // WelcomeScreen()
                    LoginScreen()
                }
            }
        }
    }
}
