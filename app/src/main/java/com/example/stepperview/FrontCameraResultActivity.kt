package com.example.stepperview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FrontCameraResultActivity : AppCompatActivity() {
    private lateinit var tvUriImage: TextView
    private val uriImage: String? by lazy {
        intent.getStringExtra(EXTRA_DATA)
    }

    companion object {
        const val EXTRA_RESULT = "extra_result_value"
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_result)
        tvUriImage = findViewById(R.id.tv_uri)
        tvUriImage.text = uriImage

        val btnUseThisPict: Button = findViewById(R.id.btn_use_pict)
        btnUseThisPict.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_RESULT, uriImage)
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