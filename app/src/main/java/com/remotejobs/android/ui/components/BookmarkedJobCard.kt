package com.remotejobs.android.ui.components

import Job
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseUser
import com.remotejobs.android.viewmodel.JobViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BookmarkedJobCard(
    viewModel: JobViewModel,
    job: Job,
    user: FirebaseUser?,
){


    val timeAgo = job.timePosted?.let { getTimeAgo(it) }
    var isJobDetailsExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = job.companyLogo,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(
                        Modifier
                            .height(16.dp)
                    )
                    OutlinedButton(onClick = { }) {
                        Text(job.type)
                    }
                }

                Spacer(Modifier.size(16.dp))

                Column {
                    Text(
                        text = job.title,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(
                        Modifier
                            .height(10.dp)
                    )
                    Text(
                        text = job.company,
                        fontSize = 8.sp
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    isJobDetailsExpanded = !isJobDetailsExpanded

                }) {
                    Text(text = if (isJobDetailsExpanded) "Close" else "View")
                }
                Spacer(
                    Modifier
                        .height(20.dp)
                )
                if (timeAgo != null) {
                    Text(
                        text = timeAgo, fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

            }
        }

    }

    if (isJobDetailsExpanded) {
        JobDetailsBottomSheet(
            job, viewModel
        ) {
            isJobDetailsExpanded = !isJobDetailsExpanded
        }
    }

}