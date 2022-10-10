package com.example.stepperview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

class StepSecondFragment : Fragment() {
    private lateinit var tvDataFromFirst: TextView

    private var callback: FragmentCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = context as? FragmentCallback
        } catch (_: Exception) {

        }
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.getStringExtra(CameraResultActivity.EXTRA_RESULT)?.let {
                    val uri = arguments?.getString(EXTRA_DATA)
                    Toast.makeText(
                        requireContext(),
                        "Data From First Fragment : $uri",
                        Toast.LENGTH_SHORT
                    ).show()
                    Toast.makeText(
                        requireContext(),
                        "Data From Camera Result: $it",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }

    companion object {
        const val EXTRA_DATA = "extra_result_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uri = arguments?.getString(EXTRA_DATA)
        tvDataFromFirst = view.findViewById(R.id.tv_welcome_fragment)
        tvDataFromFirst.text = "State 2 = $uri"
        val btnNextFragment: Button = view.findViewById(R.id.btn_next)
        btnNextFragment.setOnClickListener {
            val intent = Intent(context, FrontCameraActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}