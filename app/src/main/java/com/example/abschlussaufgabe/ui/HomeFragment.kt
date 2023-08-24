package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentHomeBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel
import com.example.abschlussaufgabe.viewmodel.FirestoreViewModel

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val authViewModel: AuthViewModel by activityViewModels()
    private val storeViewModel: FirestoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogout.setOnClickListener {
            authViewModel.logout()

            val activity: MainActivity = requireActivity() as MainActivity
            activity.toolbarTitle.text = "Angemeldet"
        }

        authViewModel.currentUser.observe(viewLifecycleOwner) { user ->
            if (user == null) {
                findNavController().navigate(R.id.loginFragment)
            }else {
                storeViewModel.getUserData(user.uid)
            }
        }
        storeViewModel.currentUser.observe(viewLifecycleOwner){user ->
            binding.tvName.text = user.name
            binding.tvPoints.text = user.score.toString()

    }

 }

}