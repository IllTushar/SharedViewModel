package com.example.sharedviewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels

class FragmentB : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_b, container, false)

        val click = view.findViewById<Button>(R.id.clickA)
        click.setOnClickListener {
            sharedViewModel.setData("Hi this is Tushar")
            val fragment = FragmentA()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentA, fragment)?.commit()
        }
        return view
    }

}