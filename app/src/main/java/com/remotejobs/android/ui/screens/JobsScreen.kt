package com.remotejobs.android.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.remotejobs.android.ui.components.JobCardList
import com.remotejobs.android.viewmodel.JobViewModel

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobsScreen(viewModel: JobViewModel) {

    val auth = Firebase.auth
    val user = auth.currentUser

    val jobs by viewModel.jobs.observeAsState(initial = emptyList())
    val allJobs = jobs.toMutableList() // a copy of all jobs

    val searchQuery = remember {
        mutableStateOf("")
    }

    val categories = listOf("Design", "Customer Service", "Sales", "Development")

    val selectedCategory = remember { mutableStateOf("") }

    val filteredJobs = if (searchQuery.value.isEmpty() && selectedCategory.value.isEmpty()) {
        allJobs
    } else if (searchQuery.value.isNotEmpty()) {
        allJobs.filter { job ->
            job.title.contains(searchQuery.value, ignoreCase = true) ||
                    job.type.contains(searchQuery.value, ignoreCase = true) ||
                    job.description.contains(searchQuery.value, ignoreCase = true) ||
                    job.location.contains(searchQuery.value, ignoreCase = true) ||
                    job.company.contains(searchQuery.value, ignoreCase = true)
        }
    } else {
        allJobs.filter { job -> job.type == selectedCategory.value }
    }

    Column {
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        Text(
            text = "Remote Jobs",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(25.dp)
        )

        TextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(
            modifier = Modifier
                .height(15.dp)
        )

        Text(
            text = "Browse by category",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        )

        Spacer(
            modifier = Modifier
                .height(15.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(state = rememberScrollState())
        ) {
            categories.forEach { category ->
                Button(
                    onClick = { selectedCategory.value = category },
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Text(category)
                }
            }
        }

        Spacer(
            modifier = Modifier
                .height(25.dp)
        )

        JobCardList(jobs = filteredJobs)
    }

}