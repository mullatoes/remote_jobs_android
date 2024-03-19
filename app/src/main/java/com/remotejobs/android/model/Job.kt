package com.remotejobs.android.model

import android.os.Parcelable
import java.time.LocalDateTime
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val title: String, //e.g SQL Developer
    val type: String, // remote onsite
    val description: String, // About job
    val company: String, // Google
    val companyLogo: String, //www.logo.com
    val timePosted: LocalDateTime,
    val skills: ArrayList<String>?, //iOS, iOS Development
    val payScaleMin: Int?, //100
    val payScaleMax: Int?, // 154
    val views: Int?, //76
    val applications: Int?, // 80
    val noOfEmployeesLowBound: Int?, //10
    val noOfEmployeesHighBound: Int?, // 500
    val companyType: String, // Staffing & Recruiting
    val companyCity: String, //Mountain View
    val companyCountry: String, // CA
    val responsibilities: ArrayList<String>?,
    val niceToHaveSkills: ArrayList<String>?,
    val experienceLevel: String,
    val duration: String,
) : Parcelable
