package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailsBottomSheet(
    company: String,
    image: String,
    title: String,
    type: String,
    timePosted: LocalDateTime,
    onDismiss: () -> Unit
) {

    val bottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = bottomSheetState) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            BottomSheetItem(company, title, type, timePosted) {
                onDismiss()
            }

        }

    }
}