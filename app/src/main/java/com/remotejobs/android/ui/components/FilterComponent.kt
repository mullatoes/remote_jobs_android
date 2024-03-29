package com.remotejobs.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.remotejobs.android.R

@Composable
fun FilterComponent(
    onFilterClick: () -> Unit,
    ) {
    LazyRow (

    ){
        item {

            Image(
                painter = painterResource(id = R.drawable.sort),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .clickable {
                        onFilterClick()
                    }
            )

        }

        item {
            FilterOption("Sort By"){

            }
        }
        item {
            FilterOption("Location") {

            }
        }
        item {
            FilterOption("Job Type") {

            }
        }
        item {
            FilterOption("Experience Level") {

            }
        }
        item {
            FilterOption("Skill") {

            }
        }
        item {
            FilterOption("Salary Range") {

            }
        }
    }
}
