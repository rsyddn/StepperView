package com.example.stepperview

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class FirstStepFragment : Fragment() {
    private var callback: FragmentCallback? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = context as? FragmentCallback
        } catch (_: Exception) {

        }
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            result.data?.getStringExtra(CameraResultActivity.EXTRA_RESULT)?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
//                callback?.onFirstFr(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNextFragment: Button = view.findViewById(R.id.btn_next)
        btnNextFragment.setOnClickListener {
            val intent = Intent(context, CameraActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}