package com.remotejobs.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>(null)
    val user: LiveData<FirebaseUser?> get() = _user

    fun setUser(newUser: FirebaseUser?) {
        _user.value = newUser
    }
}