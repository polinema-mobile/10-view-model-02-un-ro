package com.unero.login.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unero.login.models.Account

class LoginFragmentViewModelFactory: ViewModelProvider.Factory{
    private var account = Account()

    fun LoginFragmentViewModelFactory(account: Account){
        this.account = account
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
    }

}