package com.remotejobs.android.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.remotejobs.android.ui.components.JobCardList
import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobsScreen(viewModel: JobViewModel) {

    val jobs by viewModel.jobs.observeAsState(initial = emptyList())

    val auth = Firebase.auth
    val user = auth.currentUser

    JobCardList(jobs = jobs)

}