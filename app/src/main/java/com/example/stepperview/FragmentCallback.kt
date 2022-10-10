package com.example.stepperview

interface FragmentCallback {
    fun onFirstToSecondFragment(uri: String)
    fun onSecondToThirdFragment(firstData: String?, uri: String)
}