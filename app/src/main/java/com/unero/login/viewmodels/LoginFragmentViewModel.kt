package com.unero.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unero.login.models.Account

class LoginFragmentViewModel: ViewModel() {
    private var accountMutableLiveData: MutableLiveData<Account> = MutableLiveData<Account>()
    private var isLogged: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    // Object baru menggantikan object di Fragment
    var account = Account()
    val loggedLiveData: LiveData<Boolean>
        get() = isLogged


    // Ini seharusnya di Home View Model
    val accountLiveData: LiveData<Account>
        get() = accountMutableLiveData

    init {
        isLogged.value = false
    }

    private val email = "unero@gmail.com"
    private val pass = "unero"

    fun login(){

        if (account.email == email  && account.password == pass){
            // Ke Fragment Home
            accountMutableLiveData.value = account // Set ke LiveData
            isLogged.value = true
        } else if (account.email != email){
            // Salah email akan Toast
            // Toast.makeText(this, "Email Salah!", Toast.LENGTH_SHORT)
        } else if (account.password != pass){
            // Salah password akan Toast
            // Toast.makeText(this, "Password Salah!", Toast.LENGTH_SHORT)
        }
    }
}