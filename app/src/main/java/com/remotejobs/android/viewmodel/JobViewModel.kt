package com.remotejobs.android.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.firestore.Query
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
            .orderBy("timePosted", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, exception ->
                if (exception != null)
                    return@addSnapshotListener

                val jobList = mutableListOf<Job>()
                snapshot?.documents?.forEach { document ->

                    val title = document.getString("title") ?: ""
                    val type = document.getString("type") ?: ""
                    val description = document.getString("description") ?: ""
                    val company = document.getString("company") ?: ""
                    val companyLogo = document.getString("companyLogo") ?: ""
                    val timestamp: Timestamp? = document.getTimestamp("timePosted")
                    val skills = document.get("skills") as? ArrayList<String>
                    val payScaleMin = document.getLong("payScaleMin")?.toInt()
                    val payScaleMax = document.getLong("payScaleMax")?.toInt()
                    val views = document.getLong("views")?.toInt()
                    val applications = document.getLong("applications")?.toInt()
                    val noOfEmployeesLowBound = document.getLong("noOfEmployeesLowBound")?.toInt()
                    val noOfEmployeesHighBound = document.getLong("noOfEmployeesHighBound")?.toInt()
                    val companyType = document.getString("companyType") ?: ""
                    val companyCity = document.getString("companyCity") ?: ""
                    val companyCountry = document.getString("companyCountry") ?: ""
                    val responsibilities = document.get("responsibilities") as? ArrayList<String>
                    val niceToHaveSkills = document.get("niceToHaveSkills") as? ArrayList<String>
                    val experienceLevel = document.getString("experienceLevel") ?: ""
                    val duration = document.getString("duration") ?: ""

                    val datePosted: Date? = timestamp?.toDate()

                    val timePosted = datePosted?.let { convertDateToLocalDateTime(it) }


                    jobList.add(
                        Job(
                            title,
                            type,
                            description,
                            company,
                            companyLogo,
                            timePosted,
                            skills,
                            payScaleMin,
                            payScaleMax,
                            views,
                            applications,
                            noOfEmployeesLowBound,
                            noOfEmployeesHighBound,
                            companyType,
                            companyCity,
                            companyCountry,
                            responsibilities,
                            niceToHaveSkills,
                            experienceLevel,
                            duration
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