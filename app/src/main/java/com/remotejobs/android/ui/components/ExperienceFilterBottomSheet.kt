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
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceFilterBottomSheet(
    onDismiss: () -> Unit,
    onApplyFilter: (String?) -> Unit
){

        val bottomSheetState = rememberModalBottomSheetState()

    var selectedExperienceLevel by remember { mutableStateOf<String?>(null) }

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = bottomSheetState,
            modifier = Modifier.fillMaxWidth()
        ) {

            Column (
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)

            ){

                Text(text = "Filter by seniority")

                Spacer(modifier = Modifier.height(20.dp))

                ExperienceLevelItem("Senior", selectedExperienceLevel == "Senior") {
                    selectedExperienceLevel = "Senior"
                }
                ExperienceLevelItem("Mid", selectedExperienceLevel == "Mid") {
                    selectedExperienceLevel = "Mid"
                }
                ExperienceLevelItem("Junior", selectedExperienceLevel == "Junior") {
                    selectedExperienceLevel = "Junior"
                }
                ExperienceLevelItem("Intern", selectedExperienceLevel == "Intern") {
                    selectedExperienceLevel = "Intern"
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        onApplyFilter(selectedExperienceLevel?.trim())
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Apply Filter")
                }

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
}