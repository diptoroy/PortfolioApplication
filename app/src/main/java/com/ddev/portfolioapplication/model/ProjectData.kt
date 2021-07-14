package com.ddev.portfolioapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectData(
        val pName: String,
        val projectSection: List<ProjectSectionData>
): Parcelable