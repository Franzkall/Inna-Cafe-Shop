package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentLoginBinding
import com.example.abschlussaufgabe.viewmodel.AuthViewModel


class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btToRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)


            val activity: MainActivity = requireActivity() as MainActivity
            activity.toolbarTitle.text = "Registriere dich"
        }

        binding.btLogin.setOnClickListener {
            val email: String = binding.tietEmail.text.toString()
            val password: String = binding.tietPass.text.toString()
            if (email != "" && password != "") {
                viewModel.login(email, password)
            } else {
                Log.e("ERROR", "Empty field")
            }
        }

        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                findNavController().navigate(R.id.homeFragment)
            }
        }

    }
}