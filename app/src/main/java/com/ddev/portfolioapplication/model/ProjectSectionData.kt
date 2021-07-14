package com.ddev.portfolioapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectSectionData(
        val projectName: String,
        val projectImage: Int
): Parcelable
