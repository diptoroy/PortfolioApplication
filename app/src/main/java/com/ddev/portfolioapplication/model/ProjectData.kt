package com.ddev.portfolioapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectData(
        var pName: String,
        var projectSection: List<ProjectSectionData>,
        var isSelected: Boolean
): Parcelable