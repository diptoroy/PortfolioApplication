package com.ddev.portfolioapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ddev.portfolioapplication.view.EducationFragment
import com.ddev.portfolioapplication.view.WorkFragment

class CareerFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> WorkFragment()
            1 -> EducationFragment()
            else -> WorkFragment()
        }
    }

}

//class CareerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {
//
//    private val fragmentList: MutableList<Fragment> = ArrayList()
//    private val fragmentTitleList: MutableList<String> = ArrayList()
//
//    override fun getItem(position: Int): Fragment {
//        return fragmentList[position]
//    }
//
//    override fun getCount(): Int {
//       return fragmentList.size
//    }
//
//    fun addFragment(fragment: Fragment, title: String){
//        fragmentList.add(fragment)
//        fragmentTitleList.add(title)
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return fragmentTitleList[position]
//    }
//
//}