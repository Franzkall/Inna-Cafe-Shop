package com.example.abschlussaufgabe

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class HelloFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hello,container,false)

        val delayMillis = 2000L
        Handler(Looper.getMainLooper()).postDelayed({

            (activity as? MainActivity)?.navigateToNextFragment()
        }, delayMillis)

        return view

    }

    }
