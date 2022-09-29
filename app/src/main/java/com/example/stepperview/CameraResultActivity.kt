package com.example.stepperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepperview.databinding.ActivityCameraBinding
import com.example.stepperview.databinding.ActivityCameraResultBinding

class CameraResultActivity : AppCompatActivity() {
    private var _binding: ActivityCameraResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_result)
    }
}