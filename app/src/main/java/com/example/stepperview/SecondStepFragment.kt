package com.example.stepperview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.stepperview.databinding.FragmentFirstStepBinding
import com.example.stepperview.databinding.FragmentSecondStepBinding

class SecondStepFragment : Fragment() {
    private var _binding: FragmentSecondStepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinue.setOnClickListener {
            view.findNavController().navigate(R.id.action_firstStepFragment_to_cameraActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}