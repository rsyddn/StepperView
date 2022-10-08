package com.example.stepperview

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ThirdStepFragment : Fragment() {
    private lateinit var tvDataFromFirst: TextView
    private lateinit var tvDataFromSecond: TextView
    private lateinit var btnFinishUpgradeAccount: Button

    companion object {
        const val EXTRA_FIRST_DATA = "extra_first_data"
        const val EXTRA_SECOND_DATA = "extra_second_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataFromFirst = arguments?.getString(EXTRA_FIRST_DATA)
        val dataFromSecond = arguments?.getString(EXTRA_SECOND_DATA)

        tvDataFromFirst = view.findViewById(R.id.tv_welcome_fragment1)
        tvDataFromSecond = view.findViewById(R.id.tv_welcome_fragment2)
        btnFinishUpgradeAccount = view.findViewById(R.id.btn_finish)

        tvDataFromFirst.text = "State 3 Data From First Fragment= $dataFromFirst"
        tvDataFromSecond.text = "State 3 Data From Camera= $dataFromSecond"

        btnFinishUpgradeAccount.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }
}