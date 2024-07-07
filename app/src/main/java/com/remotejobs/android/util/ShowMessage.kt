package com.remotejobs.android.util

import android.content.Context
import android.widget.Toast

fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun isPasswordStrong(password: String): Boolean {
    if (password.length < 8) return false
    if (!password.any { it.isUpperCase() }) return false
    if (!password.any { it.isLowerCase() }) return false
    if (!password.any { it.isDigit() }) return false
    if (!password.any { !it.isLetterOrDigit() }) return false
    return true
}