package com.example.stepperview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UpgradeAccActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upgrade_acc)
        val mFragmentManager = supportFragmentManager
        val mFirstStepFragment = StepFirstFragment()
        val fragment = mFragmentManager.findFragmentByTag(StepFirstFragment::class.java.simpleName)
        if (fragment !is StepFirstFragment) {
            mFragmentManager
                .beginTransaction()
                .add(
                    R.id.frame_upgrade_acc,
                    mFirstStepFragment,
                    StepFirstFragment::class.java.simpleName
                )
                .commit()
        }
    }
}