package com.remotejobs.android.model

data class UserBookmarks(
    val userId: String = "",
    val bookmarkedJobIds: List<String> = listOf()
)

