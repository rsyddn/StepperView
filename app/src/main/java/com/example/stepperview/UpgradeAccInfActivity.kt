package com.example.stepperview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UpgradeAccInfActivity : AppCompatActivity() {
    private lateinit var btnUpgradeAcc: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upgrade_acc_inf)
        btnUpgradeAcc = findViewById(R.id.btn_upgrade_acc)
        btnUpgradeAcc.setOnClickListener {
            val intent = Intent(this@UpgradeAccInfActivity, UpgradeAccActivity::class.java)
            startActivity(intent)
        }
    }
}