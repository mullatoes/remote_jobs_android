package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonComponent() {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Sign In")
    }
}