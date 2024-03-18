package com.remotejobs.android.ui.components

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.remotejobs.android.model.Job
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobCardComponent(
    job: Job,
    company: String,
    image: String,
    title: String,
    type: String,
    timePosted: LocalDateTime
) {

    val timeAgo = getTimeAgo(timePosted)
    var isJobDetailsExpanded by remember { mutableStateOf(false) }

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
                    model = image,
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
                    Text(type)
                }
            }

            Spacer(Modifier.size(16.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    Modifier
                        .height(10.dp)
                )
                Text(
                    text = company,
                    fontSize = 10.sp
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                //onClick()
                isJobDetailsExpanded = !isJobDetailsExpanded

            }) {
                Text(text = if (isJobDetailsExpanded) "Close" else "View")
            }
            Text(
                text = timeAgo, fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

    if (isJobDetailsExpanded) {
        JobDetailsBottomSheet(
            job,
            company,
            image,
            title,
            type,
            timePosted
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
        difference < 60 -> "$difference mins ago"
        difference < 1440 -> "${difference / 60} hrs ago"
        difference < 10080 -> "${difference / 1440} days ago"
        difference < 43800 -> "${difference / 10080} week ago"
        difference < 525600 -> "${difference / 43800} month ago"
        else -> "${difference / 525600} years ago"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobCardList(jobs: List<Job>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(jobs) { job ->
            Spacer(modifier = Modifier.height(8.dp))
            JobCardComponent(
                job,
                company = job.company,
                image = job.companyLogo,
                title = job.title,
                type = job.type,
                timePosted = job.timePosted,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.Black, thickness = 0.5.dp)
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun JobCardComponentPreview() {
    // JobCardComponent(image = "https://media.licdn.com/dms/image/C560BAQH9qeI8ekCATA/company-logo_200_200/0/1646788525018/wonders_corporation_logo?e=1717632000&v=beta&t=uhdiDVY9jL6yEvT5sTJfOF6DwSCA9pkgBJJ7SH6fHF0", title = "Android Developer", type = "remote")
}