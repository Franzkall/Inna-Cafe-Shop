package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.User
import com.example.abschlussaufgabe.databinding.FragmentRegisterBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel
import com.example.abschlussaufgabe.viewmodel.FirestoreViewModel

class RegisterFragment: Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val authViewModel: AuthViewModel by activityViewModels()
    private val storeViewModel: FirestoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)

            val activity: MainActivity = requireActivity() as MainActivity
            activity.toolbarTitle.text = "Login"
        }

        binding.btRegister.setOnClickListener {
            val email: String = binding.tietEmail.text.toString()
            val password: String = binding.tietPass.text.toString()
            if (email != "" && password != "") {
                authViewModel.register(email, password)
            } else {
                Log.e("ERROR", "Empty field")
            }

        }

        authViewModel.currentUser.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser != null) {
                val user = User(
                    firebaseUser.uid,
                    binding.tietEmail.text.toString(),
                    binding.btRegister.text.toString()
                )
                storeViewModel.addNewUser(user)
                findNavController().navigate(R.id.casaFragment)
            }
        }

    }
}