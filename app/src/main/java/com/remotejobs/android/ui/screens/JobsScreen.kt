package com.remotejobs.android.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.remotejobs.android.ui.components.JobCardList
import com.remotejobs.android.viewmodel.JobViewModel

@Composable
fun JobsScreen(viewModel: JobViewModel){
    val jobs by viewModel.jobs.observeAsState(initial = emptyList())

    JobCardList(jobs = jobs)
}