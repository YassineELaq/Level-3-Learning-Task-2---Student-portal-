package com.example.level_3_learning_task_2_student_portalapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Website(
    var websiteTitel: String,
    var websiteURL: String

): Parcelable