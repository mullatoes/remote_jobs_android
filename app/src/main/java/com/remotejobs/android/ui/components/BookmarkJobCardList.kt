package com.remotejobs.android.ui.components

import Job
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseUser
import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BookmarkJobCardList(jobs: List<Job>, navController: NavController, user: FirebaseUser?,) {
    if (jobs.isEmpty()){

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Sorry, no jobs for that category \nTry home section for more jobs", color = Color.Gray)
        }
    }else {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(jobs) { job ->
                Spacer(modifier = Modifier.height(8.dp))
                BookmarkedJobCard(
                    viewModel = JobViewModel(),
                    job,
                    user
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(color = Color.Black, thickness = 0.5.dp)
            }
        }
    }
}