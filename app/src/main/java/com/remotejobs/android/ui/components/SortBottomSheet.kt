package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortBottomSheet(onDismiss: () -> Unit) {

    val bottomSheetState = rememberModalBottomSheetState()
    val selectedFilters = remember {
        mutableStateOf<HashSet<String>>(hashSetOf())
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            
            Text(text = "Filters")
            
            Spacer(modifier = Modifier.height(10.dp))

            FilterOptionBottomSheet(
                name = "Location",
                isSelected = selectedFilters.value.contains("Location"),
                onFilterSelected = {
                    if (selectedFilters.value.contains("Location")) {
                        selectedFilters.value.remove("Location")
                    } else {
                        selectedFilters.value.add("Location")
                    }
                }
            )

            FilterOptionBottomSheet(
                name = "Experience",
                isSelected = selectedFilters.value.contains("Experience"),
                onFilterSelected = {
                    if (selectedFilters.value.contains("Experience")) {
                        selectedFilters.value.remove("Experience")
                    } else {
                        selectedFilters.value.add("Experience")
                    }
                }
            )

            FilterOptionBottomSheet(
                name = "Salary",
                isSelected = selectedFilters.value.contains("Salary"),
                onFilterSelected = {
                    if (selectedFilters.value.contains("Salary")) {
                        selectedFilters.value.remove("Salary")
                    } else {
                        selectedFilters.value.add("Salary")
                    }
                }
            )

            FilterOptionBottomSheet(
                name = "Skill",
                isSelected = selectedFilters.value.contains("Skill"),
                onFilterSelected = {
                    if (selectedFilters.value.contains("Skill")) {
                        selectedFilters.value.remove("Skill")
                    } else {
                        selectedFilters.value.add("Skill")
                    }
                }
            )

            // Apply Filters Button
            Button(
                onClick = {
                   // onApplyFilters(selectedFilters)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Apply Filters")
            }


        }

    }
}