package com.remotejobs.android.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.remotejobs.android.ui.components.BookmarkJobCardList
import com.remotejobs.android.viewmodel.JobViewModel
import com.remotejobs.android.viewmodel.UserViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserBookmarkedJobsScreen(
    navController: NavController,
    viewModel: JobViewModel,
    userViewModel: UserViewModel,
    ) {

    val bookmarkedJobs by remember(viewModel)
    { viewModel.bookmarkedJobs }.observeAsState()

    val user = userViewModel.user.value


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bookmarks") },
                actions = {
                    IconButton(onClick = {
                        if (user != null) {
                            viewModel.getBookmarkedJobs(user)
                        }
                    }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        },
        contentColor = MaterialTheme.colorScheme.surface
    ) {


        if (user == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Please log in or create an account to view bookmarked jobs")
            }
        } else {
            if (bookmarkedJobs.isNullOrEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("You haven't bookmarked any jobs yet")
                }
            } else {

                Column(
                    Modifier.padding(5.dp)
                ) {
                    Spacer(modifier = Modifier.height(60.dp))
                    BookmarkJobCardList(bookmarkedJobs!!, navController, user)
                }
            }
        }
    }

}
