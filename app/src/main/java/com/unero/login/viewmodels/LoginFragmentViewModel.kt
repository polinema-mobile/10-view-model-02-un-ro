package com.unero.login.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unero.login.fragments.LoginFragment
import com.unero.login.models.Account

class LoginFragmentViewModel: ViewModel() {
    private var accountMutableLiveData = MutableLiveData<Account>()
    private var isLogged = MutableLiveData<Boolean>()
    private var errorMLD = MutableLiveData<String>()
    var account = Account()

    val loggedLiveData: LiveData<Boolean>
        get() = isLogged

    val accountLiveData: LiveData<Account>
        get() = accountMutableLiveData

    val errorLD: LiveData<String>
        get() = errorMLD

    init {
        isLogged.value = false
    }

    private val email = "unero@gmail.com"
    private val pass = "unero"

    fun login(){
        if (account.email == email  && account.password == pass){
            accountMutableLiveData.value = account // Set ke LiveData
            isLogged.value = true
        } else if (account.email.isBlank() && account.password.isBlank()) {
            errorMLD.value = "Please input email and password first"
        } else if (account.email != email){
            isLogged.value = false
            errorMLD.value = "Email not found"
        } else if (account.password != pass){
            isLogged.value = false
            errorMLD.value = "Wrong Password"
        }
    }
}