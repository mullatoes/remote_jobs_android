package com.remotejobs.android.model

import java.time.LocalDateTime
import java.util.Date

data class Job(
    val title: String,
    val type: String,
    val description: String,
    val location: String,
    val company: String,
    val companyLogo: String,
    val timePosted: LocalDateTime
)
