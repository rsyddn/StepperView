package com.example.stepperview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var btnUpgradeAcc: Button
    private lateinit var btnUpgradeAccDrawer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUpgradeAcc = findViewById(R.id.btn_upgrade_acc)
        btnUpgradeAccDrawer = findViewById(R.id.btn_upgrade_acc_drawer)

        btnUpgradeAcc.setOnClickListener {
            val intent = Intent(this@MainActivity, UpgradeAccInfActivity::class.java)
            startActivity(intent)
        }

        //TODO: DO DRAWER HERE
    }

}