package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent(buttonClick: () -> Unit) {
    Button(
        onClick = buttonClick,
        //  colors = ButtonDefaults.buttonColors(Color.Blue),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = CutCornerShape(5)
    ) {
        Text(text = "Sign In")
    }
}