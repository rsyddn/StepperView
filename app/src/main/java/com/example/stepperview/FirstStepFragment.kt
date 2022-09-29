package com.example.stepperview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.stepperview.databinding.FragmentFirstStepBinding

class FirstStepFragment : Fragment() {
    private var _binding: FragmentFirstStepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btnContinue.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_firstStepFragment_to_secondStepFragment))
        binding.btnContinue.setOnClickListener{
            view.findNavController().navigate(R.id.action_firstStepFragment_to_cameraActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}