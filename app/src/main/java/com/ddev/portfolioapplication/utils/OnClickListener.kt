package com.ddev.portfolioapplication.utils

import com.ddev.portfolioapplication.model.MenuData
import com.ddev.portfolioapplication.model.ProjectData

interface OnClickListener {
   fun onMenuClick(item: MenuData, position: Int)
   fun onProjectClick(item: ProjectData, position: Int)
}