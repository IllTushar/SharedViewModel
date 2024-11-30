package com.example.sharedviewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class FragmentA : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_a, container, false)
        val text = view.findViewById<TextView>(R.id.textWaiting)
        viewModel._dataSet.observe(requireActivity(), Observer { value ->
            text.text = value
        })
        val click = view.findViewById<Button>(R.id.clickB)
        click.setOnClickListener {
            val fragment = FragmentB()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentA, fragment)?.commit()
        }
        return view
    }

}