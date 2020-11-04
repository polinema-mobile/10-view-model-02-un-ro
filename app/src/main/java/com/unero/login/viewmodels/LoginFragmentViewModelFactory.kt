package com.unero.login.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unero.login.models.Account

class LoginFragmentViewModelFactory(var account: Account) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
    }
}