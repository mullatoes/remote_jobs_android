package com.remotejobs.android.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val current = Date()

    val convertDateToLocalDateTime = convertDateToLocalDateTime(current)

    println(convertDateToLocalDateTime)
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertDateToLocalDateTime(date: Date): LocalDateTime {
    return date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}