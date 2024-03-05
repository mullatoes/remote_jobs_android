package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotejobs.android.model.Job
import com.remotejobs.android.ui.screens.JobsScreen

@Composable
fun JobCardComponent(title: String, type: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text(
                text = title,
                fontSize = 18.sp
            )
            Text(
                text = type,
                fontSize = 10.sp
            )
        }

        Button(onClick = {

        }) {
            Text(text = "Apply")
        }
    }
}

@Composable
fun JobCardList(jobs: List<Job>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(jobs) { job ->
            JobCardComponent(title = job.title, type = job.type)
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun JobCardComponentPreview() {
  // JobsScreen(viewModel = )
}