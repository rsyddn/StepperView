package com.example.stepperview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: String?,
    val code: String?,
) : Parcelable