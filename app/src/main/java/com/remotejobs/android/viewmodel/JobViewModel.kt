package com.remotejobs.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.remotejobs.android.model.Job

class JobViewModel : ViewModel() {
    private var firestore = Firebase.firestore

    private val _jobs = MutableLiveData<List<Job>>()
    val jobs: LiveData<List<Job>> get() = _jobs

    init {
        fetchJobs()
    }

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

                    jobList.add(Job(title, type, description, location, company, companyLogo))
                }

                _jobs.value = jobList
            }
    }
}