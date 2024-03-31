package com.remotejobs.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun AppAlertDialog(submitUrl: String, onContinue: () -> Unit) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Let the employer know you applied or heard them from here") },
            text = {
                Column {
                    Text(
                        text = "By clicking continue, you'll be directed to the application website.",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    val message = buildAnnotatedString {
                        append("I applied or heard from you through ")
                        pushStringAnnotation(
                            tag = "Link",
                            annotation = "Link"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = androidx.compose.ui.graphics.Color.Blue,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("RemoteJobs")
                        }
                        pop()
                    }
                    ClickableText(
                        text = message,
                        onClick = { offset ->
                            message.getStringAnnotations(
                                tag = "Link",
                                start = offset,
                                end = offset
                            ).firstOrNull()?.let {
                                // Handle click on the link
                            }
                        }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        onContinue()
                    }
                ) {
                    Text(text = "Continue")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}