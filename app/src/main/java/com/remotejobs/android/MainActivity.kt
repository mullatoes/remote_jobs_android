package com.remotejobs.android

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.remotejobs.android.ui.navigation.Navigation
import com.remotejobs.android.ui.theme.RemoteJobsTheme
import com.remotejobs.android.viewmodel.JobViewModel
import com.remotejobs.android.viewmodel.ProfileViewModel
import com.remotejobs.android.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteJobsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val profileViewModel: ProfileViewModel = viewModel()
                    val jobViewModel: JobViewModel = viewModel()
                    val userViewModel: UserViewModel = viewModel()
                    Navigation(userViewModel,profileViewModel,jobViewModel)
                }
            }
        }
    }
}
