package com.example.stepperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.aceinteract.android.stepper.StepperNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button
    private lateinit var stepper: StepperNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frame_stepper) as NavHostFragment
        val navController = navHostFragment.navController

        stepper = findViewById(R.id.stepper)
        stepper.setupWithNavController(navController)

        btnPrev = findViewById(R.id.btn_prev)
        btnNext = findViewById(R.id.btn_next)

        btnPrev.setOnClickListener {
            stepper.goToPreviousStep()
        }

        btnNext.setOnClickListener {
            stepper.goToNextStep()
        }
    }

}