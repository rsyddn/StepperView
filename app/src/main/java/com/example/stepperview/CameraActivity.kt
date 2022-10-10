package com.example.stepperview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CAMERA_RESULT = "extra_camera_result"
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getStringExtra(CameraResultActivity.EXTRA_CAMERA_RESULT_DATA)?.let {
                    val intent = Intent()
                    intent.putExtra(EXTRA_CAMERA_RESULT, it)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            } else if (result.resultCode == RESULT_CANCELED) {
                //TODO: RE USE CAMERA
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        val btnTakePict: Button = findViewById(R.id.btn_take_pic)
        btnTakePict.setOnClickListener {
            val intent = Intent(this@CameraActivity, CameraResultActivity::class.java)
            val rand = (0 until 10).random()
            intent.putExtra(CameraResultActivity.EXTRA_CAMERA_CAPTURE_DATA, "URI $rand")
            resultLauncher.launch(intent)
        }
    }
}