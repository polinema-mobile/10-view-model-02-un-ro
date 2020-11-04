package com.unero.login.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.unero.login.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_splash, container, false)
        Handler(Looper.getMainLooper()).postDelayed({
            view.findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)
        return view
    }
}