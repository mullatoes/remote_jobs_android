package com.remotejobs.android.ui.components

import android.text.Layout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterOptionBottomSheet(
    name: String,
    isSelected: Boolean,
    onFilterSelected: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onFilterSelected() }
            .padding(8.dp)
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = null // Dummy onCheckedChange as we handle it with clickable modifier
        )
        Text(
            text = name,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}