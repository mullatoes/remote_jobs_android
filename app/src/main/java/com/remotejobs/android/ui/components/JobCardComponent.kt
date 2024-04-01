package com.remotejobs.android.ui.components

import Job
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.remotejobs.android.R
import com.remotejobs.android.util.showMessage
import com.remotejobs.android.viewmodel.JobViewModel
import com.remotejobs.android.viewmodel.UserViewModel
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobCardComponent(
    viewModel: JobViewModel,
    job: Job,
    userViewModel: UserViewModel
) {
    val user = userViewModel.user.value
    val timeAgo = job.timePosted?.let { getTimeAgo(it) }
    var isJobDetailsExpanded by remember { mutableStateOf(false) }

    var bookmarkImageResource by remember { mutableStateOf(R.drawable.bookmark) }


    if (user != null){
        viewModel.checkIfJobIsBookmarked(job.jobId, user.uid) { isBookmarked ->
            bookmarkImageResource = if (isBookmarked) R.drawable.bookmark_black else R.drawable.bookmark
        }
    }


    val context = LocalContext.current


    val bookmarkImageModifier = Modifier
        .size(20.dp)
        .clickable {

            if (user != null) {
                user.uid.let {
                    viewModel.toggleBookmark(job.jobId, it)
                }
            } else {
                showMessage(
                    context,
                    "Please login or create an account to bookmark a job post"
                )
            }
        }
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
                    viewModel.incrementViews(job.jobId)

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

                Spacer(
                    Modifier
                        .height(20.dp)
                )
                Image(
                    painter =
                    painterResource(
                        id = bookmarkImageResource
                    ),

                    contentDescription = null,
                    modifier = bookmarkImageModifier
                )

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

@RequiresApi(Build.VERSION_CODES.O)
fun getTimeAgo(timePosted: LocalDateTime): String {

    val now = LocalDateTime.now()
    val difference = ChronoUnit.MINUTES.between(timePosted, now)

    return when {
        difference < 1 -> "just now"
        difference < 60 -> "$difference mins ago"
        difference < 1440 -> {
            val hours = difference / 60
            if (hours == 1L) "1 hr ago" else "$hours hrs ago"
        }
        difference < 10080 -> {
            val days = difference / 1440
            if (days == 1L) "1 day ago" else "$days days ago"
        }
        difference < 43800 -> {
            val weeks = difference / 10080
            if (weeks == 1L) "1 week ago" else "$weeks weeks ago"
        }
        difference < 525600 -> {
            val months = difference / 43800
            if (months == 1L) "1 month ago" else "$months months ago"
        }
        else -> {
            val years = difference / 525600
            if (years == 1L) "1 year ago" else "$years years ago"
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobCardList(jobs: List<Job>, userViewModel: UserViewModel) {
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

        LazyColumn{
            items(jobs) { job ->
                JobCardComponent(
                    viewModel = JobViewModel(),
                    job,
                    userViewModel
                )
                Divider()
            }
        }
    }
}
