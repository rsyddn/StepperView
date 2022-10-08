package com.example.stepperview

interface FragmentCallback {
    fun onFirstFr(uri: String)
    fun onSecondFr(firstData: String?, uri: String)
}