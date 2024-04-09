package com.remotejobs.android.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.remotejobs.android.model.NewsItem
import com.remotejobs.android.ui.components.NewsListItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(){

    val newsList = listOf(
        NewsItem("Giant Squid Filmed for the First Time in Its Natural Habitat", "Scientists have captured incredible footage of a giant squid in its natural habitat for the first time ever."),
        NewsItem("James Webb Telescope Discovers Potential Signs of Life on Exoplanet", "Early data from the James Webb Space Telescope suggests the presence of potential biosignatures on a distant exoplanet."),
        NewsItem("AI Breakthrough: Machine Learns to Write Like Shakespeare", "Researchers have developed a new AI model that can generate human-quality text in the style of famous authors like William Shakespeare."),
        NewsItem("Honeybees May Be Able to Count, New Study Suggests", "A recent study suggests honeybees may have a basic understanding of numbers, challenging our assumptions about insect intelligence."),
        NewsItem("Scientists Develop Sustainable Battery Made from Wood", "A new type of battery made from sustainable wood-based materials shows promise for the future of clean energy storage.")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("News") },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) {

        LazyColumn {
            items(newsList) { newsItem ->
                NewsListItem(newsItem)
                Divider()
            }
        }
    }
}