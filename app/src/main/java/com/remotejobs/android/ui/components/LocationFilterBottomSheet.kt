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
fun LocationFilterBottomSheet(onDismiss: () -> Unit,
                              onCountrySelected: (String) -> Unit ){
    val bottomSheetState = rememberModalBottomSheetState()

    var countryText by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){

            Text(text = "Type the name of the country:")

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = countryText,
                onValueChange = { countryText = it },
                placeholder = { Text("e.g., Germany") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    onCountrySelected(countryText.trim())
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