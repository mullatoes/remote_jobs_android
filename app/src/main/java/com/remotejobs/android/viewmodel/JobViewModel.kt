package com.remotejobs.android.viewmodel

import Job
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Tasks
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.toObject
import com.remotejobs.android.model.UserBookmarks
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class JobViewModel : ViewModel() {

    private var firestore = Firebase.firestore

    private val _jobs = MutableLiveData<List<Job>>()

    val auth = com.google.firebase.ktx.Firebase.auth

    val user = auth.currentUser
    val jobs: LiveData<List<Job>> get() = _jobs

    private val _bookmarkedJobs = MutableLiveData<List<Job>>()
    val bookmarkedJobs: LiveData<List<Job>> = _bookmarkedJobs

    init {
        fetchJobs()
        if (user != null) {
            getBookmarkedJobs(user)
        }
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

                    val jobId = document.id

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
                    val submitUrl = document.getString("submitUrl") ?: ""
                    val isBookmarked = document.getBoolean("isBookmarked") ?: false

                    val datePosted: Date? = timestamp?.toDate()

                    val timePosted = datePosted?.let { convertDateToLocalDateTime(it) }


                    jobList.add(
                        Job(
                            jobId,
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
                            duration,
                            isBookmarked,
                            submitUrl
                        )
                    )
                }

                _jobs.value = jobList
            }
    }

    fun incrementViews(jobId: String){
        firestore.collection("jobs")
            .document(jobId)
            .update("views", FieldValue.increment(1))
    }

    fun incrementApplicationNumber(jobId: String){
        firestore.collection("jobs")
            .document(jobId)
            .update("applications", FieldValue.increment(1))
    }

    fun toggleBookmark(jobId: String, userId: String) {
        val userBookmarksRef = firestore.collection("user_bookmarks").document(userId)
        userBookmarksRef.get().addOnSuccessListener { document ->
            val bookmarkedJobIds = document.toObject<UserBookmarks>()?.bookmarkedJobIds ?: emptyList()

            if (bookmarkedJobIds.contains(jobId)) {
                val updatedBookmarks = bookmarkedJobIds.toMutableList()
                updatedBookmarks.remove(jobId)
                userBookmarksRef.set(UserBookmarks(userId, updatedBookmarks))
            } else {
                val updatedBookmarks = bookmarkedJobIds.toMutableList()
                updatedBookmarks.add(jobId)
                userBookmarksRef.set(UserBookmarks(userId, updatedBookmarks))
            }
        }.addOnFailureListener { exception ->
           exception.message.let {
               if (it != null) {
                   Log.d("error", it)
               }
           }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getBookmarkedJobs(user: FirebaseUser) {
        val userBookmarksRef = firestore.collection("user_bookmarks").document(user.uid)

        userBookmarksRef.get().addOnSuccessListener { document ->
            if (document.exists()) {
                val bookmarkedJobIds = document.get("bookmarkedJobIds") as? List<String> ?: emptyList()
                val jobFetchTasks = bookmarkedJobIds.map { jobId ->
                    firestore.collection("jobs").document(jobId).get()
                }
                Tasks.whenAllSuccess<DocumentSnapshot>(jobFetchTasks)
                    .addOnSuccessListener { jobSnapshots ->
                        val bookmarkedJobs = jobSnapshots.mapNotNull { snapshot ->
                            val jobId = snapshot.id
                            val title = snapshot.getString("title") ?: ""
                            val type = snapshot.getString("type") ?: ""
                            val description = snapshot.getString("description") ?: ""
                            val company = snapshot.getString("company") ?: ""
                            val companyLogo = snapshot.getString("companyLogo") ?: ""
                            val timestamp: Timestamp? = snapshot.getTimestamp("timePosted")
                            val skills = snapshot.get("skills") as? ArrayList<String>
                            val payScaleMin = snapshot.getLong("payScaleMin")?.toInt()
                            val payScaleMax = snapshot.getLong("payScaleMax")?.toInt()
                            val views = snapshot.getLong("views")?.toInt()
                            val applications = snapshot.getLong("applications")?.toInt()
                            val noOfEmployeesLowBound = snapshot.getLong("noOfEmployeesLowBound")?.toInt()
                            val noOfEmployeesHighBound = snapshot.getLong("noOfEmployeesHighBound")?.toInt()
                            val companyType = snapshot.getString("companyType") ?: ""
                            val companyCity = snapshot.getString("companyCity") ?: ""
                            val companyCountry = snapshot.getString("companyCountry") ?: ""
                            val responsibilities = snapshot.get("responsibilities") as? ArrayList<String>
                            val niceToHaveSkills = snapshot.get("niceToHaveSkills") as? ArrayList<String>
                            val experienceLevel = snapshot.getString("experienceLevel") ?: ""
                            val duration = snapshot.getString("duration") ?: ""
                            val isBookmarked = snapshot.getBoolean("isBookmarked") ?: false
                            val submitUrl = document.getString("submitUrl") ?: ""

                            val datePosted: Date? = timestamp?.toDate()
                            val timePosted = datePosted?.let { convertDateToLocalDateTime(it) }

                            Job(
                                jobId,
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
                                duration,
                                isBookmarked,
                                submitUrl
                            )
                        }
                        _bookmarkedJobs.value = bookmarkedJobs
                    }
                    .addOnFailureListener { exception ->
                        _bookmarkedJobs.value = emptyList()
                    }
            } else {
                _bookmarkedJobs.value = emptyList()
            }
        }.addOnFailureListener { exception ->
            _bookmarkedJobs.value = emptyList()
        }
    }


}

@RequiresApi(Build.VERSION_CODES.O)
fun convertDateToLocalDateTime(date: Date): LocalDateTime {
    return date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}