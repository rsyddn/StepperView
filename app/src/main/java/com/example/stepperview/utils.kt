package com.example.stepperview


import  android.content.Context

fun Context.getJsonFromRaw(file: Int): String {
    return this.resources.openRawResource(file).bufferedReader().use {
        it.readText()
    }
}