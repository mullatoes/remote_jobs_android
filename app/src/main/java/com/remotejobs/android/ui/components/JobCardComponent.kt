package com.remotejobs.android.ui.components

import Job
import android.content.Context
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.remotejobs.android.R
import com.remotejobs.android.util.AdMobUtil.getAdViewForBannerAd
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
    userViewModel: UserViewModel,

    ) {
    val user = userViewModel.user.value
    val timeAgo = job.timePosted?.let { getTimeAgo(it) }
    var isJobDetailsExpanded by remember { mutableStateOf(false) }

    var bookmarkImageResource by remember { mutableStateOf(R.drawable.bookmark) }


    if (user != null) {
        viewModel.checkIfJobIsBookmarked(job.jobId, user.uid) { isBookmarked ->
            bookmarkImageResource =
                if (isBookmarked) R.drawable.bookmark_black else R.drawable.bookmark
        }
    }


    val context = LocalContext.current


    val bookmarkImageModifier = Modifier
        .size(20.dp)
        .clickable {

        }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isJobDetailsExpanded = !isJobDetailsExpanded
                viewModel.incrementViews(job.jobId)
            }
            .padding(vertical = 6.dp, horizontal = 6.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = job.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = job.company,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                AsyncImage(
                    model = job.companyLogo,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    "${job.type} - ${job.availability}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
                IconButton(
                    onClick = {
                        if (user != null) {
                            user.uid.let {
                                viewModel.toggleBookmark(job.jobId, it)
                            }
                            showMessage(
                                context,
                                "${job.title} added to bookmarks"
                            )
                        } else {
                            showMessage(
                                context,
                                "Please login or create an account to bookmark a job post"
                            )
                        }
                    },
                    modifier = bookmarkImageModifier
                ) {
                    Icon(
                        painter = painterResource(id = bookmarkImageResource),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (timeAgo != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = timeAgo,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onBackground
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


    if (jobs.isEmpty()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Sorry, no jobs available \nTry home section for all jobs", color = Color.Gray)
        }
    } else {

        LazyColumn {

            itemsIndexed(jobs) { index, job ->
                JobCardComponent(
                    viewModel = JobViewModel(),
                    job = job,
                    userViewModel = userViewModel
                )
                Divider()

                if ((index + 1) % 7 == 0) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 8.dp)
                    ) {
                        val context = LocalContext.current
                        val adView = getAdViewForBannerAd(
                            context,
                            context.getString(R.string.banner_ad_value)
                        )
                        AndroidView(factory = { adView }) { adView ->
                            adView.layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                        }
                    }
                }
                Divider(modifier = Modifier.padding(horizontal = 8.dp))
            }

        }
    }
}




