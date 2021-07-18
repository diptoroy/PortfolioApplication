package com.ddev.portfolioapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectSectionData(
        var projectName: String,
        var projectImage: Int
): Parcelable
