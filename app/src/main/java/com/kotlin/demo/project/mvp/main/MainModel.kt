package com.kotlin.demo.project.mvp.main

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainModel (
    val title: String,
    val description: String
): Parcelable