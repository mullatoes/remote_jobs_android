package com.remotejobs.android.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.remotejobs.android.R
import com.remotejobs.android.ui.components.FilterComponent
import com.remotejobs.android.ui.components.JobCardList
import com.remotejobs.android.ui.components.LocationFilterBottomSheet
import com.remotejobs.android.ui.components.SortBottomSheet
import com.remotejobs.android.util.AdMobUtil.getAdViewForBannerAd
import com.remotejobs.android.util.fontFamily
import com.remotejobs.android.viewmodel.JobViewModel
import com.remotejobs.android.viewmodel.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobsScreen(userViewModel: UserViewModel) {

    val context = LocalContext.current

    val adView = getAdViewForBannerAd(context,"ca-app-pub-1687235289780065/4288680821")

    val viewModel: JobViewModel = viewModel()

    val jobs by viewModel.jobs.observeAsState(initial = emptyList())
    val allJobs = jobs.toMutableList()

    var searchQuery by remember { mutableStateOf("") }
    var isLocationExpanded by remember { mutableStateOf(false) }


    var isFilterSortBottomSheetExpanded by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf<String?>(null) }
    var selectedExperience by remember { mutableStateOf<String?>(null) }
    var selectedSalary by remember { mutableStateOf<String?>(null) }

    val filteredJobs = if (searchQuery.isNotEmpty()) {
        allJobs.filter { job ->
            job.title.contains(searchQuery, ignoreCase = true) ||
                    job.type.contains(searchQuery, ignoreCase = true) ||
                    job.description.contains(searchQuery, ignoreCase = true) ||
                    job.company.contains(searchQuery, ignoreCase = true)
        }
    } else {
        allJobs.filter { job ->
            (selectedLocation == null || job.companyCountry == selectedLocation) &&
                    (selectedExperience == null || job.experienceLevel == selectedExperience) &&
                    (selectedSalary == null || job.payScaleMin.toString() == selectedSalary)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Remote Jobs Worldwide", textAlign = TextAlign.Center) },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.sort),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clickable {
                                isFilterSortBottomSheetExpanded = !isFilterSortBottomSheetExpanded
                            }
                    )
                }
            )
        },
        contentColor = MaterialTheme.colorScheme.surface
    ) {

        Column(Modifier.padding(5.dp)) {

            Spacer(modifier = Modifier.height(70.dp))

            Box(Modifier.fillMaxWidth()) {
                AndroidView(factory = { adView }) { view ->
                    view.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = LocalContentColor.current
                    )
                },
                placeholder = { Text(stringResource(R.string.search_for_job_title_companies)) },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(3.dp))

            if (isFilterSortBottomSheetExpanded) {
                SortBottomSheet {
                    isFilterSortBottomSheetExpanded = !isFilterSortBottomSheetExpanded
                }
            }


            Spacer(modifier = Modifier.height(5.dp))

            JobCardList(filteredJobs, userViewModel)
        }

    }

}

