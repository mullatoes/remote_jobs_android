package com.remotejobs.android.model

data class Job(
    val title: String,
    val type: String,
    val description: String,
    val location: String,
    val company: String,
    val companyLogo: String
)
