package com.remotejobs.android.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.firestore.firestore
import com.remotejobs.android.model.Job
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class JobViewModel : ViewModel() {

    private var firestore = Firebase.firestore

    private val _jobs = MutableLiveData<List<Job>>()
    val jobs: LiveData<List<Job>> get() = _jobs

    init {
        fetchJobs()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun fetchJobs() {
        firestore.collection("jobs")
            .addSnapshotListener { snapshot, exception ->
                if (exception != null)
                    return@addSnapshotListener

                val jobList = mutableListOf<Job>()
                snapshot?.documents?.forEach { document ->

                    val title = document.getString("title") ?: ""
                    val type = document.getString("type") ?: ""
                    val description = document.getString("description") ?: ""
                    val location = document.getString("location") ?: ""
                    val company = document.getString("company") ?: ""
                    val companyLogo = document.getString("companyLogo") ?: ""
                    val timestamp: Timestamp? = document.getTimestamp("timePosted")

                    val datePosted: Date? = timestamp?.toDate()

                    val timePosted: LocalDateTime = datePosted.let {
                        convertDateToLocalDateTime(it!!)
                    }


                    jobList.add(
                        Job(
                            title,
                            type,
                            description,
                            location,
                            company,
                            companyLogo,
                            timePosted
                        )
                    )
                }

                _jobs.value = jobList
            }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertDateToLocalDateTime(date: Date): LocalDateTime {
    return date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}