package com.example.stepperview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class SecondStepFragment : Fragment() {
    private lateinit var tvDataFromFirst : TextView

    companion object {
        const val EXTRA_DATA = "extra_result_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uri = arguments?.getString(EXTRA_DATA)
        tvDataFromFirst = view.findViewById(R.id.tv_welcome_fragment)
        tvDataFromFirst.text = "State 2 = $uri"
    }
}