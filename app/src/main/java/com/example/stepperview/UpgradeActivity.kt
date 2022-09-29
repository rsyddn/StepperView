package com.example.stepperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stepperview.databinding.ActivityUpgradeBinding

class UpgradeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpgradeBinding
    private var mCurrentFragment: Fragment? = FirstStepFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upgrade)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_upgrade)
        if (savedInstanceState == null) {
            mCurrentFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commit()
            }
        } else {
            mCurrentFragment = supportFragmentManager.getFragment(savedInstanceState, "FRAGMENT")
            mCurrentFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commit()
            }
        }

    }


}