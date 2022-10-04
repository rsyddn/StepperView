package com.example.stepperview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepperview.databinding.ActivityCameraBinding
import com.example.stepperview.databinding.ActivityCameraResultBinding

class CameraResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraResultBinding

    companion object {
        const val EXTRA_RESULT = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_result)
        binding = ActivityCameraResultBinding.inflate(layoutInflater)
        val imgResultString = intent.getStringExtra(EXTRA_RESULT)
        print(imgResultString)
        val imgResultUri = Uri.parse(imgResultString)
        binding.ivResult.setImageURI(imgResultUri)
    }
}