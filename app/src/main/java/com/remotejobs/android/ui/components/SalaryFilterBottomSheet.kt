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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalaryFilterBottomSheet(
    onDismiss: () -> Unit,
    onApplyFilter: (String?) -> Unit
){


    val bottomSheetState = rememberModalBottomSheetState()

    var selectedSalaryOption by remember { mutableStateOf<String?>(null) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ){

            Text(text = "Filter by salary:")

            Spacer(modifier = Modifier.height(20.dp))

            SalaryOption("Below $50,000", selectedSalaryOption == "Below $50,000") {
                selectedSalaryOption = "49999"
            }
            SalaryOption("$50,000 - $100,000", selectedSalaryOption == "$50,000 - $100,000") {
                selectedSalaryOption = "99999"
            }
            SalaryOption("Above $100,000", selectedSalaryOption == "Above $100,000") {
                selectedSalaryOption = "100001"
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    onApplyFilter(selectedSalaryOption?.trim())
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