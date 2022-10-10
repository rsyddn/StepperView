package com.example.stepperview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CameraResultActivity : AppCompatActivity() {
    private lateinit var tvUriImage: TextView

    private val uriImage: String? by lazy {
        intent.getStringExtra(EXTRA_CAMERA_CAPTURE_DATA)
    }

    companion object {
        const val EXTRA_CAMERA_RESULT_DATA = "extra_camera_result_data"
        const val EXTRA_CAMERA_CAPTURE_DATA = "extra_camera_capture_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_result)
        tvUriImage = findViewById(R.id.tv_uri)
        tvUriImage.text = uriImage

        val btnUseThisPict: Button = findViewById(R.id.btn_use_pict)
        btnUseThisPict.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_CAMERA_RESULT_DATA, uriImage)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val btnChangePict: Button = findViewById(R.id.btn_change_pict)
        btnChangePict.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}