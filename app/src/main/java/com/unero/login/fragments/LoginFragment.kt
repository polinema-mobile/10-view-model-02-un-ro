package com.unero.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unero.login.R
import com.unero.login.databinding.FragmentLoginBinding
import com.unero.login.models.Account
import com.unero.login.viewmodels.LoginFragmentViewModel
import com.unero.login.viewmodels.LoginFragmentViewModelFactory
import es.dmoral.toasty.Toasty

class LoginFragment : Fragment() {

    private var sendThis: String = ""
    private lateinit var binding: FragmentLoginBinding
    private lateinit var mViewModels: LoginFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        mViewModels = ViewModelProvider(this).get(LoginFragmentViewModel::class.java)
        binding.viewModel = mViewModels
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModels.accountLiveData.observe(viewLifecycleOwner, {
            sendThis = it.email
        })

        mViewModels.loggedLiveData.observe(viewLifecycleOwner, {
            if (it) {
                context?.let { it1 -> Toasty.success(it1, "Login Success", Toast.LENGTH_SHORT, true).show() }
                val bundle = bundleOf("email" to sendThis)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            }
        })

        mViewModels.errorLD.observe(viewLifecycleOwner, {
            context?.let { it1 -> Toasty.error(it1, it, Toast.LENGTH_SHORT, true ).show() }
        })
    }
}