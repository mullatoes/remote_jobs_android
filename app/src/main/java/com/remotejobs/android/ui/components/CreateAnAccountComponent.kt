package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CreateAnAccountComponent() {
    Text(
        text = "Create an account",
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}