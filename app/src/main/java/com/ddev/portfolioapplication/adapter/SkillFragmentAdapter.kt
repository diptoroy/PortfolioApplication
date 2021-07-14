package com.ddev.portfolioapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ddev.portfolioapplication.view.EducationFragment
import com.ddev.portfolioapplication.view.SkillLanguageFragment
import com.ddev.portfolioapplication.view.SkillToolsFragment
import com.ddev.portfolioapplication.view.WorkFragment

class SkillFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SkillLanguageFragment()
            1 -> SkillToolsFragment()
            else -> SkillLanguageFragment()
        }
    }

}