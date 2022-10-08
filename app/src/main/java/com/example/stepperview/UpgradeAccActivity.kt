package com.example.stepperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts

class UpgradeAccActivity : AppCompatActivity(), FragmentCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upgrade_acc)
        val mFragmentManager = supportFragmentManager
        val mFirstStepFragment = FirstStepFragment()
        val fragment = mFragmentManager.findFragmentByTag(FirstStepFragment::class.java.simpleName)
        if (fragment !is FirstStepFragment) {
            mFragmentManager
                .beginTransaction()
                .add(
                    R.id.frame_upgrade_acc,
                    mFirstStepFragment,
                    FirstStepFragment::class.java.simpleName
                )
                .commit()
        }
    }

    override fun onFirstFr(uri: String) {
        val bundle = Bundle()
        bundle.putString(SecondStepFragment.EXTRA_DATA, uri)

        val mFragmentManager = supportFragmentManager
        val mSecondStepFragment = SecondStepFragment()
        mSecondStepFragment.arguments = bundle

        val fragment = mFragmentManager.findFragmentByTag(SecondStepFragment::class.java.simpleName)

        if (fragment !is SecondStepFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(
                    R.id.frame_upgrade_acc,
                    mSecondStepFragment,
                    SecondStepFragment::class.java.simpleName
                )
                .commit()
        }
    }

    override fun onSecondFr(firstData: String?, uri: String) {
        val bundle = Bundle()
        bundle.putString(ThirdStepFragment.EXTRA_FIRST_DATA, firstData)
        bundle.putString(ThirdStepFragment.EXTRA_SECOND_DATA, uri)

        val mFragmentManager = supportFragmentManager
        val mThirdStepFragment = ThirdStepFragment()
        mThirdStepFragment.arguments = bundle

        val fragment = mFragmentManager.findFragmentByTag(ThirdStepFragment::class.java.simpleName)
        if (fragment !is ThirdStepFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(
                    R.id.frame_upgrade_acc,
                    mThirdStepFragment,
                    ThirdStepFragment::class.java.simpleName
                )
                .commit()
        }
    }
}