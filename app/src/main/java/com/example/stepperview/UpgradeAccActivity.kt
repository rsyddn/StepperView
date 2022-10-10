package com.example.stepperview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UpgradeAccActivity : AppCompatActivity(), FragmentCallback {
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

    override fun onFirstToSecondFragment(uri: String) {
        val bundle = Bundle()
        bundle.putString(StepSecondFragment.EXTRA_DATA, uri)

        val mFragmentManager = supportFragmentManager
        val mSecondStepFragment = StepSecondFragment()
        mSecondStepFragment.arguments = bundle

        val fragment = mFragmentManager.findFragmentByTag(StepSecondFragment::class.java.simpleName)

        if (fragment !is StepSecondFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(
                    R.id.frame_upgrade_acc,
                    mSecondStepFragment,
                    StepSecondFragment::class.java.simpleName
                )
                .commit()
        }
    }

    override fun onSecondToThirdFragment(firstData: String?, uri: String) {
        TODO("Not yet implemented")
    }
}