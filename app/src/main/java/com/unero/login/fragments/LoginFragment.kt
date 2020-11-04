package com.unero.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unero.login.R
import com.unero.login.databinding.FragmentLoginBinding
import com.unero.login.models.Account
import com.unero.login.viewmodels.LoginFragmentViewModel
import com.unero.login.viewmodels.LoginFragmentViewModelFactory

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val mViewModels: LoginFragmentViewModel = ViewModelProvider(this).get(LoginFragmentViewModel::class.java)
        binding.viewModel?.loggedLiveData?.observe(viewLifecycleOwner, Observer { isLogged ->
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        })
        binding.viewModel = mViewModels
        binding.lifecycleOwner = this
        return binding.root
    }
}