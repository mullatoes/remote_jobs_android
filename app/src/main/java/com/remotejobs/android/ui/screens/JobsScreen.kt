package com.remotejobs.android.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.remotejobs.android.R
import com.remotejobs.android.ui.components.FilterComponent
import com.remotejobs.android.ui.components.JobCardList
import com.remotejobs.android.ui.components.SortBottomSheet
import com.remotejobs.android.ui.components.TopAppBarWithTextAndImage
import com.remotejobs.android.viewmodel.JobViewModel

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobsScreen(navController: NavController) {

    val viewModel: JobViewModel = viewModel()

    val jobs by viewModel.jobs.observeAsState(initial = emptyList())
    val allJobs = jobs.toMutableList()

    var searchQuery by remember { mutableStateOf("") }


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

    Column(Modifier.padding(5.dp)) {

        TopAppBarWithTextAndImage(title = "Remote Jobs", icon = R.drawable.notifications)

        Spacer(modifier = Modifier.height(16.dp))

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
            placeholder = { Text("Search for job title, companies...") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Filter by category",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        FilterComponent(
            onFilterClick = {
                isFilterSortBottomSheetExpanded = !isFilterSortBottomSheetExpanded
            },
            onExperienceFilter = {
                                 selectedExperience = it
            },
            onLocationFilter = {
                               selectedLocation = it
            },
            onSalaryFilter = {
                selectedSalary = it
            }
        )

        if (isFilterSortBottomSheetExpanded) {
            SortBottomSheet {
                isFilterSortBottomSheetExpanded = !isFilterSortBottomSheetExpanded
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        JobCardList(filteredJobs, navController)
    }

}