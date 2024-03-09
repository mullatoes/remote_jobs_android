package com.remotejobs.android.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpViewModel : ViewModel() {

    private val auth = Firebase.auth

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun signUp(email: String, password: String, onComplete: (Boolean) -> Unit) {
        _isLoading.value = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false
                if (task.isSuccessful) {
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
    }
}