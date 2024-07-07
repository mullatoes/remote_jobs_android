package com.remotejobs.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.remotejobs.android.R

@Composable
fun FilterComponent(
    onFilterClick: () -> Unit,
    onLocationFilter: (String?) -> Unit,
    onExperienceFilter: (String?) -> Unit,
    onSalaryFilter: (String?) -> Unit
) {
    var isLocationExpanded by remember { mutableStateOf(false) }
    var isExperienceSheetExpanded by remember { mutableStateOf(false) }
    var isSalaryExpanded by remember { mutableStateOf(false) }

    Column {
        if (isLocationExpanded) {
            LocationFilterBottomSheet(
                onDismiss = {
                    isLocationExpanded = false
                }
            ){ selectedLocation ->
               onLocationFilter(selectedLocation)
            }
        }

        if (isExperienceSheetExpanded){
            ExperienceFilterBottomSheet(
                onDismiss = {
                    isExperienceSheetExpanded = false
                }
            ){ selectedExperience ->
                onExperienceFilter(selectedExperience)
            }
        }

        if (isSalaryExpanded){
            SalaryFilterBottomSheet(onDismiss = {
                isSalaryExpanded = false
            }) {selectedSalary ->
                onSalaryFilter(selectedSalary)
            }
        }

        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.padding(16.dp)
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
                FilterOption("Location") {
                    isLocationExpanded = !isLocationExpanded
                }
            }
        }
    }
}

